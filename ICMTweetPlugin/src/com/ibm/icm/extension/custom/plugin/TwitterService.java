package com.ibm.icm.extension.custom.plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.ibm.ecm.extension.PluginResponseUtil;
import com.ibm.ecm.extension.PluginService;
import com.ibm.ecm.extension.PluginServiceCallbacks;
import com.ibm.ecm.json.JSONResponse;
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
		//set headers
//		response.addHeader("Access-Control-Allow-Origin","*");
//		response.addHeader("Access-Control-Allow-Methods","GET,POST");
//		response.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
		
		
//		jsonResponse.put("results", JSONObject.parse(getSampleTweets()));
		jsonResponse.put("results", "a test");
		PluginResponseUtil.writeJSONResponse(request, response, jsonResponse, callbacks, "TwitterService");
		
	}
	
	public String getSampleTweets() { //public String getSampleTweets(JSONObject twitterCredentials, String outputName, String searchTerms)
//		StringBuffer retrievedTweets = null;
		String retrievedTweets = "Something here";
		
		//1)use same ICN httpclient jar - nope, didn't work
		
		//2) see what class loader is being used
//		ClassLoader loader = ICMTweetPlugin.class.getClassLoader();
//		if(loader.getClass() != null) {
//			String bla = loader.getResource("/com/ibm/icm/extension/custom/plugin/ICMTweetPlugin").toString();
//		}
		
//		HttpClient httpClient = HttpClientBuilder.create().build();
//		String url = "https://9703b749-0d64-4fc6-a0c2-57af929c69e9:zHZ54TpZym@cdeservice.mybluemix.net:443/api/v1/messages/search?q=IBMECM&size=1";
//		HttpGet httpGet = new HttpGet(url);
//		
//		HttpResponse response = null;
//		
//		
//		try {
//			httpGet.addHeader("Access-Control-Allow-Origin","*");
//			httpGet.addHeader("Access-Control-Allow-Methods","GET,POST");
//			httpGet.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
//			
//			response = httpClient.execute(httpGet);
//			
//			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//			String inputLine;
//	        retrievedTweets = new StringBuffer();
//	 
//	        while ((inputLine = reader.readLine()) != null) {
//	        	retrievedTweets.append(inputLine);
//	        }
//	        reader.close();
//			
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		finally {
//			
//		}
		
//		return retrievedTweets.toString();
		return retrievedTweets;
	}
}
