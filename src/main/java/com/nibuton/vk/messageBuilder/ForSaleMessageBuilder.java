package com.nibuton.vk.messageBuilder;

import com.nibuton.vk.answer.InterestingAnswer;

public class ForSaleMessageBuilder implements MessageBuilder{

	@Override
	public String buildMessage(InterestingAnswer answer) {
		StringBuilder messageToSend = new StringBuilder("Продают ");
		for(String gameName : answer.getNames()) {
			if (answer.getNames().indexOf(gameName) == 0) {
				messageToSend.append(gameName);
			}
			else {
				messageToSend.append(" и " + gameName);
			}
		}
		return messageToSend.toString();
	}

}
