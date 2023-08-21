package com.Hotel.microservice.exceptions;

public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		
		super(string);
	}
	
	
	public ResourceNotFoundException() {
		
		
		super("User not found");
		
	}
	
	

}
