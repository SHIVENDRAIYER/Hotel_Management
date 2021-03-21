package com.cg.apps.hotel_booking.guestms.controllers;

import java.util.*;
import com.cg.apps.hotel_booking.guestms.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.apps.hotel_booking.guestms.service.*;
import com.cg.apps.hotel_booking.guestms.entities.*;
import com.cg.apps.hotel_booking.guestms.dto.*;

@RequestMapping("/guests")
@RestController
public class GuestRestController {

	@Autowired
	private IGuestService guestService;

	@Autowired
	private GuestUtil guestUtil;

	@PostMapping("/add")
	public GuestDetails addGuest(@RequestBody GuestAddRequest request) {

		Guest guest = guestService.allotRoom(request.getAadharId(), request.getGuestName(), request.getHotelId(),
				request.getFloorNumber(), request.getRoomNumber(), request.getRent());

		return guestUtil.toDetailGuest(guest);

	}

	@PutMapping("/checkout")
	public GuestDetails checkout(@RequestBody GuestCheckedoutRequest request) {

		Guest guest = guestService.checkout(request.getGuestId(), request.getHotelId(), request.getFloorNumber(),
				request.getRoomNumber());

		return guestUtil.toDetailGuest(guest);
	}

	@GetMapping("/guest/transactionHistory/{id}")
	public List<GuestTransactionDetails> getHistory(@PathVariable("id") Long guestId) {

		List<GuestTransaction> guestTransactions = guestService.transactionsHistory(guestId);

		return guestUtil.toDetailGuestTransactionList(guestTransactions);

	}

}
