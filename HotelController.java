package com.Hotel.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hotel.microservice.entities.Hotel;
import com.Hotel.microservice.exceptions.ResourceNotFoundException;
import com.Hotel.microservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelservice;
	
	//create
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.create(hotel));
		
	}
	
	//get single
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Hotel>> getSingle(@PathVariable String name){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hotelservice.get(name));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.getAll());
		
	}
	
	
	
}
