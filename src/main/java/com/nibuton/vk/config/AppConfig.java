package com.nibuton.vk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nibuton.vk.algorithm.EditingDistanceAlgorithm;
import com.nibuton.vk.algorithm.NativeSearch;
import com.nibuton.vk.messageBuilder.ForSaleMessageBuilder;
import com.nibuton.vk.messageBuilder.MessageBuilder;
import com.nibuton.vk.notifier.Notifier;
import com.nibuton.vk.notifier.TelegramNotifier;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;

@Configuration
public class AppConfig {
	
	@Value("${user_id}")
	int userId;
	
	@Value("${access_token}")
	String accessToken;
	
	
	@Bean
	public VkApiClient getVkApiCient() {
		TransportClient transportClient = HttpTransportClient.getInstance();
		return new VkApiClient(transportClient);
	}
	
	@Bean
	public UserActor getUserActor() {
		return new UserActor(userId, accessToken);
	}
	
	@Bean
	public EditingDistanceAlgorithm getEditingDistanceAlgorithm() {
		return new NativeSearch();
	}
	
	@Bean
	public MessageBuilder getMessageBuilder() {
		return new ForSaleMessageBuilder();
	}
	
	@Bean
	public Notifier getTelegramNotifier() {
		return new TelegramNotifier();
	}
	
}
