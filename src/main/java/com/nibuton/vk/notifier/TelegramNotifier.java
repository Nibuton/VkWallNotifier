package com.nibuton.vk.notifier;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;

public class TelegramNotifier implements Notifier{

	@Value("${group_id}")
	private String groupId;
	
	@Value("${chat_id}")
	String CHAT_ID;
	
	@Value("${token}")
	String TOKEN;
    
    public TelegramNotifier() {};


	@Override
	public void sendMessage(String... strings) throws Exception {
		String msg = strings[0];
		String from_id = strings[1];
		String id = strings[2];
        String uri = "https://api.telegram.org/bot" + TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" 
        		+ URLEncoder.encode(msg +"\n " + "https://vk.com/" + groupId + "?w=wall" 
        				+ from_id + "_" + id,"UTF-8");
        HttpGet request = new HttpGet(uri);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        httpClient.execute(request);
	}
    
    
    
}
