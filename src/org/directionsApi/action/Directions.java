package org.directionsApi.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.directionsApi.dao.DirectionInputDAO;
import org.directionsApi.dao.DirectionOutputTO;
import org.directionsApi.sei.IDirectionAPIService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Directions extends ActionSupport implements ModelDriven<DirectionInputDAO> {

	
	private static final long serialVersionUID = 1L;
	private DirectionInputDAO directionInput=new DirectionInputDAO();
	private String result;
	private DirectionOutputTO directionOutput;
	
	private IDirectionAPIService directionService;
	
	public DirectionInputDAO getDirectionInput() {
		return directionInput;
	}

	public void setDirectionInput(DirectionInputDAO directionInput) {
		this.directionInput = directionInput;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute(){
		WebApplicationContext context =
		WebApplicationContextUtils.getRequiredWebApplicationContext(
                                ServletActionContext.getServletContext());
		directionService=(IDirectionAPIService) context.getBean("directionService");
		try {
			 directionOutput=directionService.getDirections(directionInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 if(directionOutput.getResponseCode()==400){
				setResult("Bad request");
				return INPUT;
		 }
		 else{
			 setResult(directionOutput.getJsonOutput());
			 if(directionOutput.getResponseCode()==200) return SUCCESS;
			 else	return ERROR; 
		 }
			
			
		}
		
	
	
	
	@Override
	public DirectionInputDAO getModel() {
			return directionInput;
	}
	
	
		
	}

