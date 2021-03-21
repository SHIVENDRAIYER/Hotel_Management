package com.cg.apps.hotel_booking.hotelms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.hotel_booking.guestms.entities.*;
import java.util.*;
import com.cg.apps.hotel_booking.hotelms.entities.*;
import com.cg.apps.hotel_booking.hotelms.util.*;
import com.cg.apps.hotel_booking.hotelms.service.*;
import com.cg.apps.hotel_booking.hotelms.dto.*;
import com.cg.apps.hotel_booking.guestms.util.*;
import com.cg.apps.hotel_booking.guestms.dto.*;

@RequestMapping("/hotels")
@RestController
public class HotelRestController {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private HotelUtil hotelUtil;

	@Autowired
	private GuestUtil guestUtil;

	@PostMapping(value = "/add")
	public HotelDetails addHotel(@RequestBody HotelAddRequest request) {

		Hotel hotel = hotelService.addHotel(request.getHotelName(), request.getAddress(), null);
		return hotelUtil.toDetails(hotel);
	}

	@GetMapping(value = "/byid/{id}")
	public HotelDetails findById(@PathVariable("id") Long hotelId) {

		Hotel hotel = hotelService.findById(hotelId);
		return hotelUtil.toDetails(hotel);
	}

	@GetMapping(value = "/{id}/guests")
	public Set<GuestDetails> findAllGuestsInHotel(@PathVariable("id") Long hotelId) {

		Set<Guest> guests = hotelService.findAllGuestsLivingInHotel(hotelId);
		return guestUtil.toDetailSet(guests);
	}

	@GetMapping(value = "/{id}/checkoutguests")
	public List<GuestDetails> guestsCheckedOutTodayInHotel(@PathVariable("id") Long hotelId) {

		List<Guest> guests = hotelService.findAllGuestsCheckedOutTodayInHotel(hotelId);
		return guestUtil.toDetailList(guests);
	}

}
