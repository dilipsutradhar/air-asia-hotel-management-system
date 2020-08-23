package com.org.air.asia.model;

import javax.persistence.Embeddable;

@Embeddable
public class Rooms {
	
	int roomCount;
	int occupiedRooms;
	int freeRooms;
	int freeStandardRooms;
	int freeBusinessRooms;
	int freePremiumRooms;
	
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public int getOccupiedRooms() {
		return occupiedRooms;
	}
	public void setOccupiedRooms(int occupiedRooms) {
		this.occupiedRooms = occupiedRooms;
	}
	public int getFreeRooms() {
		return freeRooms;
	}
	public void setFreeRooms(int freeRooms) {
		this.freeRooms = freeRooms;
	}
	public int getFreeStandardRooms() {
		return freeStandardRooms;
	}
	public void setFreeStandardRooms(int freeStandardRooms) {
		this.freeStandardRooms = freeStandardRooms;
	}
	public int getFreeBusinessRooms() {
		return freeBusinessRooms;
	}
	public void setFreeBusinessRooms(int freeBusinessRooms) {
		this.freeBusinessRooms = freeBusinessRooms;
	}
	public int getFreePremiumRooms() {
		return freePremiumRooms;
	}
	public void setFreePremiumRooms(int freePremiumRooms) {
		this.freePremiumRooms = freePremiumRooms;
	}
	
	

}
