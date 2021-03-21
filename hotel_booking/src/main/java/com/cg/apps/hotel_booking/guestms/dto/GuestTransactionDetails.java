package com.cg.apps.hotel_booking.guestms.dto;

import java.time.LocalDateTime;

public class GuestTransactionDetails {

	private Long guestTransactionId;
	private double amount;
	private LocalDateTime dateTime;
	private Long guestId;

	public GuestTransactionDetails() {

	}

	public Long getGuestTransactionId() {

		return guestTransactionId;
	}

	public void setGuestTransactionId(Long guestTransactionId) {

		this.guestTransactionId = guestTransactionId;
	}

	public double getAmount() {

		return amount;
	}

	public void setAmount(double amount) {

		this.amount = amount;
	}

	public LocalDateTime getDateTime() {

		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {

		this.dateTime = dateTime;
	}

	public Long getGuestId() {

		return guestId;
	}

	public void setGuestId(Long guestId) {

		this.guestId = guestId;
	}

}
