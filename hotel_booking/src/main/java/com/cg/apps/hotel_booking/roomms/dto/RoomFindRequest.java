package com.cg.apps.hotel_booking.roomms.dto;

public class RoomFindRequest {
	
	private Long hotelId;
	private int floorNum;
	private int roomNum;
	
	public RoomFindRequest() {
		
	}

	public Long getHotelId() {
		
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		
		this.hotelId = hotelId;
	}

	public int getFloorNum() {
		
		return floorNum;
	}

	public void setFloorNum(int floorNum) {
		
		this.floorNum = floorNum;
	}

	public int getRoomNum() {
		
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		
		this.roomNum = roomNum;
	}
	
	

}
