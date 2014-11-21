package org.directionsApi.dao;

public class DirectionInputDAO {

	private String mode;
	private String units;
	private String[] avoid;
	private String origin;
	private String destination;
	private String[] waypoints;
	private boolean optimize;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String[] getAvoid() {
		return avoid;
	}
	public void setAvoid(String[] avoid) {
		this.avoid = avoid;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String[] getWaypoints() {
		return waypoints;
	}
	public void setWaypoints(String[] waypoints) {
		this.waypoints = waypoints;
	}
	public boolean isOptimize() {
		return optimize;
	}
	public void setOptimize(boolean optimize) {
		this.optimize = optimize;
	}
	
	
	
	

	

}
