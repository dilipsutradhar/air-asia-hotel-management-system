package com.org.air.asia.model;

import java.io.Serializable;

public enum HotelStatus implements Serializable {
	
	RECEIVING, FULL, MAINTAINANCE;

	public String getStatus() {
        return this.name();
    }
	
}
