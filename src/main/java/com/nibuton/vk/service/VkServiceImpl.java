package com.nibuton.vk.service;

import org.springframework.stereotype.Service;

import com.nibuton.vk.algorithm.EditingDistanceAlgorithm;
import com.nibuton.vk.answer.InterestingAnswer;
import com.nibuton.vk.api.VkAPIGroupRequestManager;
import com.nibuton.vk.messageBuilder.MessageBuilder;
import com.nibuton.vk.notifier.Notifier;

@Service
public class VkServiceImpl extends VkService{
	
	public VkServiceImpl(VkAPIGroupRequestManager groupRequestManager, EditingDistanceAlgorithm algo,
			MessageBuilder messageBuilder, Notifier notifier) {
		super(groupRequestManager, algo, messageBuilder, notifier);
	}

	@Override
	InterestingAnswer isInteresting(String text, EditingDistanceAlgorithm alg) {
		InterestingAnswer answer = new InterestingAnswer();
		answer.setInteresting(false);
		for (int i = 0; i < names.length; i++) {
			int dist = alg.getPartialEditingDistance(text.toLowerCase(), names[i]);
			if (dist >= 90) {
				answer.addGameName(names[i]);
				answer.setInteresting(true);
			}
		}
		return answer;
	}

}
