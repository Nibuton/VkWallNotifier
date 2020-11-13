package com.nibuton.vk.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.wall.WallpostFull;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

@Component
public class VkAPIGroupRequestManager {
	
	UserActor userActor;

	VkApiClient vk;

	@Autowired
	public VkAPIGroupRequestManager(UserActor userActor, VkApiClient vk) {
		this.userActor = userActor;
		this.vk = vk;
	}
	
	public List<WallpostFull> getWallPosts(String groupId, int numberOfPosts) throws ApiException, ClientException {
		
		GetResponse getResponse = vk.wall().get(userActor).ownerId(getGroupIdByName(groupId)).count(numberOfPosts).execute();
		List<WallpostFull> posts = getResponse.getItems();
		return posts;
	}
	
	private int getGroupIdByName(String groupId) throws ApiException, ClientException {
		List<GroupFull> gr = vk.groups().getById(userActor).groupId(groupId).execute();
		return -gr.get(0).getId();		
	}

}
