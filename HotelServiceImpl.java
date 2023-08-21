package com.Hotel.microservice.services;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.Hotel.microservice.entities.Hotel;
import com.Hotel.microservice.exceptions.ResourceNotFoundException;
import com.Hotel.microservice.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelrepo;
	
	Pageable sortedByName = 
			  PageRequest.of(0, 3, Sort.by("name"));

			Pageable sortedByPriceDesc = 
			  PageRequest.of(0, 3, Sort.by("price").descending());

			Pageable sortedByPriceDescNameAsc = 
			  PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")));
	
	@Override
	public Hotel create(Hotel hotel) {
		
		String randomId= UUID.randomUUID().toString();
		
		hotel.setId(randomId);
		
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {

		return hotelrepo.findAll();
	}

	@Override
	public List<Hotel> get(String name) throws ResourceNotFoundException  {

		
	 List<Hotel> h= hotelrepo.findAllByName(name, sortedByName);
	 
	 if(h== null) {
		 
		 
		 throw new ResourceNotFoundException("No hotel with user id "+ h+" was found .");
		 
	 }
	 
	 
	 return h;
	
		
	}

}
