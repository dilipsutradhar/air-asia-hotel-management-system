package com.org.air.asia.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.air.asia.model.HotelStatus;
import com.org.air.asia.model.Hotels;

@Repository
public interface HotelsRepo extends MongoRepository<Hotels, String>{
	
	public Hotels findByHotelName(String firstName);
	
	public List<Hotels> findByStatus(HotelStatus status);
	
}
