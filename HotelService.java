package com.Hotel.microservice.services;

import java.util.List;

import com.Hotel.microservice.entities.Hotel;
import com.Hotel.microservice.exceptions.ResourceNotFoundException;

public interface HotelService {
	
	//create
		
	Hotel create (Hotel hotel);
	
	
	//get all
	
	List<Hotel> getAll();
	
	//get single
	
	List<Hotel> get(String id) throws ResourceNotFoundException;

}
