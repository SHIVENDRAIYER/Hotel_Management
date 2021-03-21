package com.cg.apps.hotel_booking.hotelms.dto;

import java.util.*;
public class HotelDetails {
	
	 private Long hotelId;
	 private String hotelName;
	 private String address;
	 
	 private List<Long> roomIds;
	 
	 public HotelDetails() {
		 
	 }

	public Long getHotelId() {
		
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		
		this.hotelName = hotelName;
	}

	public String getAddress() {
		
		return address;
	}

	public void setAddress(String address) {
		
		this.address = address;
	}

	public List<Long> getRoomIds() {
		
		return roomIds;
	}

	public void setRoomIds(List<Long> roomIds) {
		
		this.roomIds = roomIds;
	}
	 
	 


}
