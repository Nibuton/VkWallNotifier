package com.nibuton.vk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.nibuton.vk.algorithm.EditingDistanceAlgorithm;
import com.nibuton.vk.answer.InterestingAnswer;
import com.nibuton.vk.api.VkAPIGroupRequestManager;
import com.nibuton.vk.messageBuilder.MessageBuilder;
import com.nibuton.vk.notifier.Notifier;
import com.nibuton.vk.notifier.TelegramNotifier;
import com.vk.api.sdk.objects.wall.WallpostFull;

abstract public class VkService{
	
	VkAPIGroupRequestManager groupRequestManager;
	EditingDistanceAlgorithm algo;
	MessageBuilder messageBuilder;
	Notifier notifier;
	
	@Value("${names}")
	String[] names;
	
	@Value("${thread_sleep_time}")
	int threadSleepTime;
	
	@Autowired
	public VkService(VkAPIGroupRequestManager groupRequestManager, EditingDistanceAlgorithm algo, MessageBuilder messageBuilder, Notifier notifier) {
		this.groupRequestManager = groupRequestManager;
		this.algo = algo;
		this.messageBuilder = messageBuilder;
		this.notifier = notifier;
	}
	
	public void getInterestingPosts(String groupId, int numberOfPosts) {
		List<WallpostFull> previousPosts = new ArrayList<WallpostFull>();
		while(true) {
			try {
				List<WallpostFull> posts = groupRequestManager.getWallPosts(groupId, numberOfPosts);
				for (WallpostFull post : posts) {
					InterestingAnswer answer = isInteresting(post.getText(), algo);
					if ((!previousPosts.contains(post)) && answer.isInteresting()) {
						String messageToSend = messageBuilder.buildMessage(answer);
						notifier.sendMessage(messageToSend.toString() + " " +  post.getText(),post.getFromId().toString(),post.getId().toString());
					}
				}
				previousPosts = posts;
				Thread.sleep(threadSleepTime);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	abstract InterestingAnswer isInteresting(String text, EditingDistanceAlgorithm alg);
	
}
