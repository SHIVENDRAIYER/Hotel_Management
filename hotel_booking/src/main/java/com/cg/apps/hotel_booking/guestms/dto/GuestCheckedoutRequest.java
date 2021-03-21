package com.cg.apps.hotel_booking.guestms.dto;

public class GuestCheckedoutRequest {
	
	private Long guestId;
	private Long hotelId; 
	private int roomNumber;
	private int floorNumber;
	
	public GuestCheckedoutRequest() {
		
	}

	public Long getGuestId() {
		
		return guestId;
	}

	public void setGuestId(Long guestId) {
		
		this.guestId = guestId;
	}

	public Long getHotelId() {
		
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		
		this.hotelId = hotelId;
	}

	public int getRoomNumber() {
		
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		
		this.roomNumber = roomNumber;
	}

	public int getFloorNumber() {
		
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		
		this.floorNumber = floorNumber;
	}
	
	

}
