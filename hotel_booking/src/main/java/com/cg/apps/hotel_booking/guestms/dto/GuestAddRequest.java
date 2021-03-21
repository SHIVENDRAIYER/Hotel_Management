package com.cg.apps.hotel_booking.guestms.dto;

public class GuestAddRequest {

	private String aadharId;
	private String guestName;
	private Long hotelId;
	private int floorNumber;
	private int roomNumber;
	private double rent;

	public GuestAddRequest() {

	}

	public String getAadharId() {

		return aadharId;
	}

	public void setAadharId(String aadharId) {

		this.aadharId = aadharId;
	}

	public String getGuestName() {

		return guestName;
	}

	public void setGuestName(String guestName) {

		this.guestName = guestName;
	}

	public Long getHotelId() {

		return hotelId;
	}

	public void setHotelId(Long hotelId) {

		this.hotelId = hotelId;
	}

	public int getFloorNumber() {

		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {

		this.floorNumber = floorNumber;
	}

	public int getRoomNumber() {

		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {

		this.roomNumber = roomNumber;
	}

	public double getRent() {

		return rent;
	}

	public void setRent(double rent) {

		this.rent = rent;
	}

}
