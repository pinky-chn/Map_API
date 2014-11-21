<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome To Navigator</title>
<script src="../js/navigation.js"></script>
<link rel="stylesheet" type="text/css" href="../css/navigation.css">

</head>


<body>
	<img src="../images/directions_img1.gif" alt="Welcome to Navigator" height="80" width="95"/>
	<h2>Welcome to Navigator!</h2>
	<hr size="4"/>
	<p id=note>Note: Fields marked by the red asterisk (*) sign are mandatory.</p>
	<s:form method="post" id="directionForm" name="directionForm" action="/direction" onsubmit="return validate()">
		<table id=modeSelection>
			<tr>
				<td> <b>Select Mode:</b></td>
				<td><input type="radio" id="mode" name="mode" value="driving" onClick="enableWayPoint('addWaypointButton')" checked="checked"/>
				<img id="1" src="../images/car-icon.png" alt="Personal vehicle" height="25" width="25"/></td>
				<td><input type="radio" id="mode" name="mode" value="transit" onClick="disableWayPoint('waypointsTable','addWaypointButton')" />
				<img id="2" src="../images/bus-icon.png" alt="Public Transport" height="25" width="25" /></td>
				<td><input type="radio" id="mode" name="mode" value="walking" onClick="enableWayPoint('addWaypointButton')"/>
				<img id="3" src="../images/walking.png" alt="Walking" height="25" width="25" /></td>
				<td><input type="radio" id="mode" name="mode" value="bicycling" onClick="enableWayPoint('addWaypointButton')"/>
				<img id="4" src="../images/cycling.gif" alt="Cycling" height="25" width="25"/></td>
				
			</tr>
			</table>
			<table>
			<tr>
				<td> <b>Select Unit (optional):</b></td>
				<td><input type="radio" id="units" name="units" value="metric"/> Metric (Kilometers & Meters)</td>
				<td><input type="radio" id="units" name="units" value="imperial" /> Imperial (Miles & Feet)</td>
				
			</tr>
			</table>
			
			<table>
			<tr>
				<td> <b>Avoid:</b> </td>
			</tr>
			<tr>
				<td id=note>(Note: the addition of restrictions does not preclude routes that include the restricted feature;
				 it simply biases the result to more favorable routes.)</td>
			</tr>
			<tr>
				<td> <input type="checkbox" id="avoid" name="avoid" value="tolls"/>Tolls</td>
			</tr>
			<tr>
				<td> <input type="checkbox" id="avoid" name="avoid" value="highways"/>Highways</td>
			</tr>
			<tr>
				<td> <input type="checkbox" id="avoid" name="avoid" value="ferries"/>Ferries</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td><span id=mandatory><sub>*</sub></span><b> Origin: </b></td>
				<td><input type="text" id="origin" name="origin" /></td>
			</tr>
			<tr>
				<td><span id=mandatory><sub>*</sub></span><b> Destination: </b></td>
				<td><input type="text" id="destination" name="destination" /></td>
	
			</tr>
		</table> 
		
		<table id="waypointsTable">
			<tr>
				
				<td><input type="button" id="addWaypointButton" value="Add Waypoint (Optional)" onclick="onAddWayPoint('waypointsTable')" /></td>
			</tr>
			<tr>
				
				<td id="option" colspan="5" hidden="hidden"><input type="checkbox" id="optimize" name="optimize" value="true"/>
				Optimize route by rearranging waypoints in more efficient order
				</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td><s:submit value="Get Directions" /></td>
			</tr>
		</table>

	</s:form>
</body>

</html>