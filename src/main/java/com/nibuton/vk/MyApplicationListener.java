package com.nibuton.vk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.nibuton.vk.service.VkService;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

	VkService vkService;
	
	@Value("${group_id}")
	String groupId;
	
	@Value("${number_of_posts}")
	int numberOfPosts;
	

	@Autowired
	public MyApplicationListener(VkService vkService) {
		this.vkService = vkService;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event){
		
		vkService.getInterestingPosts(groupId, numberOfPosts);
		
	}
	

}
