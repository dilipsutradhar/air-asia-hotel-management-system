package com.org.air.asia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.air.asia.model.HotelStatus;
import com.org.air.asia.model.Hotels;
import com.org.air.asia.service.HotelServices;
@Controller
@RestController
public class HotelsController {
	
	@Autowired
	private HotelServices HotelsService;
	
	@RequestMapping(method = RequestMethod.GET, path="/app2/getAllRegisteredHotels")
	public List<Hotels> findAll() {
		return HotelsService.getAll();

		//return new ResponseEntity<List<Hotels>>(list, HttpStatus.FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/app2/getHotelInfoByName")
	public Hotels getHotelInfo(@RequestParam String hotelName) {
		return HotelsService.getByhotelName(hotelName);

		//return new ResponseEntity<Hotels>(hotels, HttpStatus.FOUND);
	}
	
	@RequestMapping("/app2/getUsingStatus")
	public List<Hotels> getHotelsByStatus(@RequestParam HotelStatus status) {
		return HotelsService.getByStatus(status);
	}
	
	@RequestMapping("/app2/getAvailableHotelsByRoomType")
	public List<Hotels> getAvailableHotelsByType(@RequestParam String roomType) {
		return HotelsService.getAvailableHotelListByType(roomType);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/app2/RegisteraNewHotel", consumes = "application/json")
	public Hotels addHotel(@RequestBody Hotels hotel) {
		return HotelsService.create(hotel);
		//return new ResponseEntity<Hotels>(h, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/app2/updateExistingHotelInfo", consumes = "application/json")
	public ResponseEntity<Hotels> update(@RequestParam String hotelName, @RequestParam String hotelAddress, @RequestParam HotelStatus hotelStatus) {
		Hotels p = HotelsService.update(hotelName, hotelAddress, hotelStatus);
		return new ResponseEntity<Hotels>(p, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.DELETE, path = "/app2/deRegisterHotel")
	public String delete(@RequestParam String hotelName) {
		HotelsService.delete(hotelName);
		return "Deleted "+hotelName;
	}
	@RequestMapping ("/app2/deleteAll")
	public String deleteAll() {
		HotelsService.deleteAll();
		return "Deleted all records";
	}

}
