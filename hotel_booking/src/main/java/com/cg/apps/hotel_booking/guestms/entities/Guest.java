package com.cg.apps.hotel_booking.guestms.entities;

import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import com.cg.apps.hotel_booking.roomms.entities.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Guest {

	@GeneratedValue
	@Id
	private Long guestId;
	private String guestName;
	private String aadharId;

	@OneToOne
	private Room room;

	private LocalDateTime rentedDateTime;

	@OneToMany(mappedBy = "guest", fetch = FetchType.EAGER)
	private List<GuestTransaction> transactions;

	@OneToOne
	private GuestTransaction recentTransaction;

	private LocalDateTime checkoutDateTime;

	public Guest() {

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

	public Room getRoom() {

		return room;
	}

	public void setRoom(Room room) {

		this.room = room;
	}

	public LocalDateTime getRentedDateTime() {

		return rentedDateTime;
	}

	public void setRentedDateTime(LocalDateTime rentedDateTime) {

		this.rentedDateTime = rentedDateTime;
	}

	public List<GuestTransaction> getTransactions() {

		return transactions;
	}

	public void setTransactions(List<GuestTransaction> transactions) {

		this.transactions = transactions;
	}

	public GuestTransaction getRecentTransaction() {

		return recentTransaction;
	}

	public void setRecentTransaction(GuestTransaction recentTransaction) {

		this.recentTransaction = recentTransaction;
	}

	public LocalDateTime getCheckoutDateTime() {

		return checkoutDateTime;
	}

	public void setCheckoutDateTime(LocalDateTime checkoutDateTime) {

		this.checkoutDateTime = checkoutDateTime;
	}

	@Override
	public String toString() {

		return "Guest [guestId=" + guestId + ", guestName=" + guestName + ", aadharId=" + aadharId + ", room=" + room
				+ ", rentedDateTime=" + rentedDateTime + ", transactions=" + transactions + ", recentTransaction="
				+ recentTransaction + ", checkoutDateTime=" + checkoutDateTime + "]";
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

		Guest other = (Guest) obj;
		if (guestId == null) {

			if (other.guestId != null) {

				return false;
			}

		} else if (!guestId.equals(other.guestId)) {

			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(guestId);
	}

}
