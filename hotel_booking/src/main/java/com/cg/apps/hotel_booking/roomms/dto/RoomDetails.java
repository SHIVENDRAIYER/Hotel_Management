package com.cg.apps.hotel_booking.roomms.dto;

public class RoomDetails {
	
	private Long roomId;
	private Integer floorNum;
	private Integer roomNum;
	private Long hotelId;
    private String hotelName;
    private Boolean available;
	private double cost;
	
	public RoomDetails() {
		
	}

	public Long getRoomId() {
		
		return roomId;
	}

	public void setRoomId(Long roomId) {
		
		this.roomId = roomId;
	}

	public Integer getFloorNum() {
		
		return floorNum;
	}

	public void setFloorNum(Integer floorNum) {
		
		this.floorNum = floorNum;
	}

	public Integer getRoomNum() {
		
		return roomNum;
	}

	public void setRoomNum(Integer roomNum) {
		
		this.roomNum = roomNum;
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

	public Boolean getAvailable() {
		
		return available;
	}

	public void setAvailable(Boolean available) {
		
		this.available = available;
	}

	public double getCost() {
		
		return cost;
	}

	public void setCost(double cost) {
		
		this.cost = cost;
	}
	
	

}
