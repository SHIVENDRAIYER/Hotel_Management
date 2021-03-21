package com.cg.apps.hotel_booking.guestms.util;

import com.cg.apps.hotel_booking.guestms.entities.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.cg.apps.hotel_booking.guestms.dto.*;

@Component
public class GuestUtil {

	public GuestDetails toDetailGuest(Guest guest) {

		GuestDetails guestDetails = new GuestDetails();

		guestDetails.setGuestId(guest.getGuestId());
		guestDetails.setAadharId(guest.getAadharId());
		guestDetails.setGuestName(guest.getGuestName());
		guestDetails.setCheckoutDateTime(guest.getCheckoutDateTime());
		guestDetails.setRoomId(guest.getRoom().getRoomId());
		guestDetails.setAmount(guest.getRecentTransaction().getAmount());

		return guestDetails;
	}

	public List<GuestDetails> toDetailList(List<Guest> guests) {

		List<GuestDetails> guestDetailsList = new ArrayList<>();
		for (Guest guest : guests) {

			guestDetailsList.add(toDetailGuest(guest));
		}

		return guestDetailsList;
	}

	public Set<GuestDetails> toDetailSet(Set<Guest> guests) {

		Set<GuestDetails> guestDetailsSet = new HashSet<>();
		for (Guest guest : guests) {

			guestDetailsSet.add(toDetailGuest(guest));
		}

		return guestDetailsSet;
	}

	public GuestTransactionDetails toDetailGuestTransaction(GuestTransaction guestTransaction) {

		GuestTransactionDetails guestTransactionDetails = new GuestTransactionDetails();
		guestTransactionDetails.setGuestTransactionId(guestTransaction.getGuestTransactionId());
		guestTransactionDetails.setAmount(guestTransaction.getAmount());
		guestTransactionDetails.setDateTime(guestTransaction.getDateTime());
		guestTransactionDetails.setGuestId(guestTransaction.getGuest().getGuestId());

		return guestTransactionDetails;
	}

	public List<GuestTransactionDetails> toDetailGuestTransactionList(List<GuestTransaction> guestTransactions) {

		List<GuestTransactionDetails> guestTransactionDetailsList = new ArrayList<>();
		for (GuestTransaction guestTransaction : guestTransactions) {

			guestTransactionDetailsList.add(toDetailGuestTransaction(guestTransaction));
		}

		return guestTransactionDetailsList;
	}

}
