package com.ibm.icm.extension.custom.plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import com.ibm.ecm.extension.PluginResponseUtil;
import com.ibm.ecm.extension.PluginService;
import com.ibm.ecm.extension.PluginServiceCallbacks;
import com.ibm.ecm.json.JSONResponse;
import com.ibm.ecm.util.*;
import com.ibm.json.java.JSONObject;


public class TwitterService extends PluginService {
	
	/**
	 * Returns the unique identifier for this service.
	 * <p>
	 * <strong>Important:</strong> This identifier is used in URLs so it must
	 * contain only alphanumeric characters.
	 * </p>
	 * 
	 * @return A <code>String</code> that is used to identify the service.
	 */
	@Override
	public String getId() {
		return "TwitterService";
	}
	
	/**
	 * Performs the action of this service.
	 * 
	 * @param callbacks
	 *            An instance of the <code>PluginServiceCallbacks</code> class
	 *            that contains several functions that can be used by the
	 *            service. These functions provide access to the plug-in
	 *            configuration and content server APIs.
	 * @param request
	 *            The <code>HttpServletRequest</code> object that provides the
	 *            request. The service can access the invocation parameters from
	 *            the request.
	 * @param response
	 *            The <code>HttpServletResponse</code> object that is generated
	 *            by the service. The service can get the output stream and
	 *            write the response. The response must be in JSON format.
	 * @throws Exception
	 *             For exceptions that occur when the service is running. If the
	 *             logging level is high enough to log errors, information about
	 *             the exception is logged by IBM Content Navigator.
	 */
	@Override
	public void execute(PluginServiceCallbacks callbacks, HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		JSONResponse jsonResponse = new JSONResponse();
		
//		String tweets = getSampleTweets();
		jsonResponse.put("results", getSampleTweets());
		PluginResponseUtil.writeJSONResponse(request, response, jsonResponse, callbacks, "TwitterService");
		
	}
	
	public JSONObject getSampleTweets() { //public String getSampleTweets(JSONObject twitterCredentials, String outputName, String searchTerms)
		
		
		JSONObject twitterServiceResults = new JSONObject();
		twitterServiceResults.put("results", "{nothing here}");
		try {
			
			URL url = new URL("https://cdeservice.mybluemix.net:443/api/v1/messages/search?q=%23IBMAnalytics&size=5");
//			URL url = new URL("https://9703b749-0d64-4fc6-a0c2-57af929c69e9:zHZ54TpZym@cdeservice.mybluemix.net:443/api/v1/messages/search?q=IBM&size=1");
			
			try {
				HttpsURLConnection bluemixConnection = (HttpsURLConnection) url.openConnection();
//				String credentials = URLEncoder.encode("OTcwM2I3NDktMGQ2NC00ZmM2LWEwYzItNTdhZjkyOWM2OWU5OnpIWjU0VHBaeW0=", "utf-8");
				
//				bluemixConnection.setRequestProperty("Authorization","Basic " + credentials);
				bluemixConnection.setRequestProperty("Authorization","Basic OTcwM2I3NDktMGQ2NC00ZmM2LWEwYzItNTdhZjkyOWM2OWU5OnpIWjU0VHBaeW0=");
				bluemixConnection.setRequestMethod("GET");
				
				int responseCode = bluemixConnection.getResponseCode();
				System.out.println("Response code: " + responseCode);
				System.out.println("Error: " + bluemixConnection.getErrorStream());
				System.out.println("Response message: " + bluemixConnection.getResponseMessage());
				
				if(responseCode == 200) {
					StringBuffer incomingTweets = new StringBuffer();
					
					InputStreamReader input = new InputStreamReader(bluemixConnection.getInputStream(), "utf-8"); 
					String encoding = input.getEncoding();
					BufferedReader incomingText = new BufferedReader(input);
					String line = "";
					while((line = incomingText.readLine()) != null) {
						incomingTweets.append(line);
					}
					incomingText.close();
					
					return (JSONObject) twitterServiceResults.put("results", incomingTweets.toString());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			}			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return twitterServiceResults;
		
	}
}
