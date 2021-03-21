package com.cg.apps.hotel_booking.guestms.dto;

import java.time.LocalDateTime;
public class GuestDetails {
	
	private Long guestId;
	private String guestName;
    private String aadharId;
    private Long roomId;
    private double amount;
    private LocalDateTime checkoutDateTime;
    
    public GuestDetails() {
    	
    }

	public Long getGuestId() {
		
		return guestId;
	}

	public void setGuestId(Long guestId) {
		
		this.guestId = guestId;
	}

	public String getGuestName() {
		
		return guestName;
	}

	public void setGuestName(String guestName) {
		
		this.guestName = guestName;
	}

	public String getAadharId() {
		
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		
		this.aadharId = aadharId;
	}

	public Long getRoomId() {
		
		return roomId;
	}

	public void setRoomId(Long roomId) {
		
		this.roomId = roomId;
	}

	public double getAmount() {
		
		return amount;
	}

	public void setAmount(double amount) {
		
		this.amount = amount;
	}

	public LocalDateTime getCheckoutDateTime() {
		
		return checkoutDateTime;
	}

	public void setCheckoutDateTime(LocalDateTime checkoutDateTime) {
		
		this.checkoutDateTime = checkoutDateTime;
	}
    
    
}
