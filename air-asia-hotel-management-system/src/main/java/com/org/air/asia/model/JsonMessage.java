package com.org.air.asia.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//using this class to generate the json messsage form my application
public class JsonMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hotels hotels = new Hotels();
		hotels.setId("1");
		hotels.setHotelName("Taj");
		Rooms rooms=new Rooms();
		rooms.setRoomCount(300);
		rooms.setOccupiedRooms(50);
		rooms.setFreeRooms(250);
		rooms.setFreeStandardRooms(150);
		rooms.setFreeBusinessRooms(50);
		rooms.setFreePremiumRooms(50);
		
		hotels.setRooms(rooms);
		hotels.setHotelAddress("105-Banjara Hills Hydrabad',505");
		
		hotels.setStatus(HotelStatus.RECEIVING);
		
		
		ObjectMapper om = new ObjectMapper();
	      String jsonString = null;
		try {
			jsonString = om.writeValueAsString(hotels);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(jsonString);

	}

}
