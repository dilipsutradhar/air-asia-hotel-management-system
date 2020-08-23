package com.org.air.asia.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.air.asia.model.HotelStatus;
import com.org.air.asia.model.Hotels;
import com.org.air.asia.repository.HotelsRepo;

@Service
public class HotelServices {

	@Autowired
	private HotelsRepo hotelsRepo;

	// Create operation to add/register or to On board a new Hotel in the AirAsia
	// HMS System
	public Hotels create(Hotels hotels) {
		return hotelsRepo.save(hotels);
	}

	// Retrieve operation to get all registered hotel information from the system
	public List<Hotels> getAll() {
		return hotelsRepo.findAll();
	}

	// retrieve a particular hotel info using its the hotel name.
	public Hotels getByhotelName(String hotelName) {
		return hotelsRepo.findByHotelName(hotelName);
	}

	// retrieve a particular hotel info using its current Status.
	public List<Hotels> getByStatus(HotelStatus status) {
		return hotelsRepo.findByStatus(status);
	}

	// Update operation existing hotel info.
	public Hotels update(String hotelName, String hotelAddress, HotelStatus hotelStatus) {
		Hotels hotels = hotelsRepo.findByHotelName(hotelName);
		hotels.setHotelName(hotelName);
		hotels.setHotelAddress(hotelAddress);
		hotels.setStatus(hotelStatus);

		return hotelsRepo.save(hotels);
	}

	// delete a existing hotel which is no longer registered with AirAsia
	public void delete(String hotelName) {
		Hotels p = hotelsRepo.findByHotelName(hotelName);
		hotelsRepo.delete(p);
	}

	public void deleteAll() {
		hotelsRepo.deleteAll();
	}

	public List<Hotels> getAvailableHotelListByType(String roomType) {
		List<Hotels> hotels = hotelsRepo.findAll();
		List<Hotels> filteredHotels = new LinkedList();
		for (Hotels hotel : hotels) {
			switch (roomType) {
			case "STANDARD":
				if (hotel.getRooms().getFreeStandardRooms() > 0) {
					filteredHotels.add(hotel);
				}
				break;
			case "BUSINESS":
				if (hotel.getRooms().getFreeBusinessRooms() > 0) {
					filteredHotels.add(hotel);
				}
				break;
			case "PREMIUM":
				if (hotel.getRooms().getFreePremiumRooms() > 0) {
					filteredHotels.add(hotel);
				}
				break;
			default:
				System.out.println("Un-Defined Type");
			}
		}
		return filteredHotels;
	}

}
