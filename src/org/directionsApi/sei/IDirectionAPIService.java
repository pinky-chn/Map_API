package org.directionsApi.sei;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.directionsApi.dao.DirectionInputDAO;
import org.directionsApi.dao.DirectionOutputTO;

public interface IDirectionAPIService {

	public DirectionOutputTO getDirections(DirectionInputDAO directionInput) throws IOException,MalformedURLException, ProtocolException;

	
}
