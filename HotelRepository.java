package com.Hotel.microservice.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.microservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	Hotel findById(String id);
	
	List<Hotel> findAllByName(String name, Pageable pageable);

}
