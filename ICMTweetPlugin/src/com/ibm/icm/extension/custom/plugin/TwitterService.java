package com.ibm.icm.extension.custom.plugin;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class TwitterService {
	
	private static TwitterService instance = null;
	
	protected TwitterService(){
		//exists only to defeat instantiation
	}
	
	public static TwitterService getInstance() {
		if(instance == null)
			instance = new TwitterService();
		return instance;
	}
	
	public String getSampleTweets(JSONObject twitterCredentials, String outputName, String searchTerms) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = "https://9703b749-0d64-4fc6-a0c2-57af929c69e9:zHZ54TpZym@cdeservice.mybluemix.net:443/api/v1/messages/search?q=IBMECM&size=1";
		HttpGet httpGet = new HttpGet(url);
		
		CloseableHttpResponse response = null;
		StringBuffer retrievedTweets = null;
		
		try {
			response = httpClient.execute(httpGet);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String inputLine;
	        retrievedTweets = new StringBuffer();
	 
	        while ((inputLine = reader.readLine()) != null) {
	        	retrievedTweets.append(inputLine);
	        }
	        reader.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return retrievedTweets.toString();
	}

}