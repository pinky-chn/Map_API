package org.directionsApi.dao;

public class DirectionOutputTO {
	private int responseCode;
	private String jsonOutput;
	
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getJsonOutput() {
		return jsonOutput;
	}
	public void setJsonOutput(String jsonOutput) {
		this.jsonOutput = jsonOutput;
	}
	
}
