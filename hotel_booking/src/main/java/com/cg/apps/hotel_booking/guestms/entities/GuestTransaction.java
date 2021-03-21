package com.cg.apps.hotel_booking.guestms.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class GuestTransaction {

	@GeneratedValue
	@Id
	private Long guestTransactionId;
	private double amount;
	private LocalDateTime dateTime;

	@ManyToOne
	private Guest guest;

	public GuestTransaction() {

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

	public Guest getGuest() {

		return guest;
	}

	public void setGuest(Guest guest) {

		this.guest = guest;
	}

	@Override
	public String toString() {

		return "GuestTransaction [guestTransactionId=" + guestTransactionId + ", amount=" + amount + ", dateTime="
				+ dateTime + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			
			return true;
		}
		
		if (obj == null) {
			
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			
			return false;
		}
		
		GuestTransaction other = (GuestTransaction) obj;
		if (guestTransactionId == null) {
			
			if (other.guestTransactionId != null) {
				
				return false;
			}
			
		} else if (!guestTransactionId.equals(other.guestTransactionId)) {
			
			return false;
		}
		
		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(guestTransactionId);
	}

}