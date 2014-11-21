package org.directionsApi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.directionsApi.dao.DirectionInputDAO;
import org.directionsApi.dao.DirectionOutputTO;
import org.directionsApi.sei.IDirectionAPIService;
import org.directionsApi.utils.WebUtility;
import org.springframework.context.MessageSource;

public class DirectionAPIServiceImpl implements IDirectionAPIService {

private static final String outputType="json";
private DirectionOutputTO directionOutput=new DirectionOutputTO();
	
private MessageSource apiMessageSource;
private MessageSource browserMessageSource;


	public MessageSource getApiMessageSource() {
	return apiMessageSource;
	}

	public void setApiMessageSource(MessageSource apiMessageSource) {
	this.apiMessageSource = apiMessageSource;
	}

	public MessageSource getBrowserMessageSource() {
	return browserMessageSource;
	}

	public void setBrowserMessageSource(MessageSource browserMessageSource) {
	this.browserMessageSource = browserMessageSource;
	}



	@Override
	public DirectionOutputTO getDirections(DirectionInputDAO directionInput) throws IOException,MalformedURLException, ProtocolException {
		
		String url = setUrl(directionInput);
		 
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		con.setRequestMethod("GET");
		
		//add request header
		con.setRequestProperty("User-Agent", this.browserMessageSource.getMessage("user-agent", null, null));
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		directionOutput.setJsonOutput(response.toString());
		directionOutput.setResponseCode(responseCode);
		
		return directionOutput;
	}

	public String setUrl(DirectionInputDAO directionInput){
		StringBuilder url=new StringBuilder();
		url.append(this.apiMessageSource.getMessage("api_base_url", null, null));
		url.append(outputType+"?");
		url.append("key="+this.apiMessageSource.getMessage("key", null, null));
		url.append("&origin="+WebUtility.percentEncode(directionInput.getOrigin()));
		url.append("&destination="+WebUtility.percentEncode(directionInput.getDestination()));
		url.append("&mode="+directionInput.getMode());
		if(directionInput.getUnits()!=null){
		url.append("&units="+directionInput.getUnits());
		}
		
		if(directionInput.getWaypoints()!=null){
			url.append("&waypoints=");
			if(directionInput.isOptimize()==true){
				url.append("optimize:true|");
			}
			url.append(WebUtility.percentEncode(urlString(directionInput.getWaypoints())));
			}
		if(directionInput.getAvoid()!=null){
			url.append("&avoid="+urlString(directionInput.getAvoid()));
		}
		return url.toString();
		
	}

	

	private String urlString(String[] inpArray) {
		StringBuilder outputString=new StringBuilder();
		for(int i=0;i<inpArray.length;i++){
			outputString.append(inpArray[i]);
			if(i!=inpArray.length-1){
				outputString.append("|");
			}
		}
		return outputString.toString();
	}
	
	

	
}
