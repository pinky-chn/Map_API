/**
 * author: Pinky Chauhan
 */

var numWayPoints=0;
var row=1;

function enableWayPoint(addWaypointButton){
	
	var button=document.forms[0][addWaypointButton];
	button.removeAttribute("disabled");
	
}

function disableWayPoint(waypointsTable,addWaypointButton){
	
	var button=document.forms[0][addWaypointButton];
	
	
		//alert("Waypoints can't be added for Transit mode");
		button.setAttribute("disabled","disabled");
		//optimizeCheckBox.setAttribute("disabled","disabled");
		var table=document.getElementById("waypointsTable");
		var num_rows=table.rows.length;
		for(var i=1;i<num_rows-1;i++){
			table.deleteRow(1);
		}
		numWayPoints=0;
		row=1;
	
		setOptimizationCheckBox();
	
}

function onAddWayPoint(tableId){
	if(numWayPoints>=8){
		alert("You can enter a maximum of 8 waypoints");
	}
	else{
		numWayPoints++;
		
		var table=document.getElementById(tableId);
		
		var col1=document.createElement("td");
		var col2=document.createElement("td");
		var col3=document.createElement("td"); 
		
		var newRow=table.insertRow(row);
		
		var textFieldLabel=document.createTextNode("Waypoint:");
		//textFieldLabel.setAttribute("id","textField");
		
		var input=document.createElement("input");
		input.setAttribute("type","text");
		input.setAttribute("id", "waypoints");
		input.setAttribute("name", "waypoints");
		
		var img=document.createElement("img");
		img.setAttribute("src","../images/X_button.png");
		img.setAttribute("height","15");
		img.setAttribute("width","15");
		img.setAttribute("onClick","deleteWayPointRow('"+row+"')");
		
		col1.appendChild(textFieldLabel);
		col2.appendChild(input);
		col3.appendChild(img);
		
		newRow.appendChild(col1);
		newRow.appendChild(col2);
		newRow.appendChild(col3);
		row++;
		
		setOptimizationCheckBox();
		
	}
	
}

function deleteWayPointRow(rowIndex){
	var table=document.getElementById("waypointsTable");
	var num_Rows=table.rows.length;
	table.deleteRow(rowIndex);
	numWayPoints--;
	
	 for(var i=rowIndex;i<num_Rows-2;i++){
		table.rows[i].cells[2].children[0].setAttribute("onClick","deleteWayPointRow('"+i+"')");
		 
	}  
	
	row--;
	setOptimizationCheckBox();
}	

function setOptimizationCheckBox(){
	var table=document.getElementById("waypointsTable");
	var optimizeCheckBoxCol=table.rows[table.rows.length-1].cells[0];
	if(numWayPoints>=2){
		optimizeCheckBoxCol.removeAttribute("hidden");
		
	}
	else{
		optimizeCheckBoxCol.setAttribute("hidden","hidden");
		document.forms[0]["optimize"].checked=false;
	}
}

function validate(){
	
	var origin=document.forms["directionForm"]["origin"].value;
	var destination=document.forms["directionForm"]["destination"].value;
	if(origin==null || origin.trim()==""){
		alert("Origin field can't be left blank");
		return false;
	}
	
	else if(destination==null || destination.trim()==""){
		alert("Destination field can't be left blank");
		return false;
	}
	
	else return true;
}
	

