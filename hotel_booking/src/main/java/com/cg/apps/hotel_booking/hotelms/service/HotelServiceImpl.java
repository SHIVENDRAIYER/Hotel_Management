package com.cg.apps.hotel_booking.hotelms.service;

import java.util.*;
import com.cg.apps.hotel_booking.roomms.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.hotel_booking.guestms.entities.Guest;
import com.cg.apps.hotel_booking.hotelms.dao.*;

import com.cg.apps.hotel_booking.hotelms.entities.Hotel;
import com.cg.apps.hotel_booking.hotelms.exceptions.*;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public Hotel findById(Long hotelId) {

		Optional<Hotel> optional = hotelRepository.findById(hotelId);
		if (!optional.isPresent()) {

			throw new HotelNotFoundException("hotel not found for hotelId=" + hotelId);
		}
		return optional.get();
	}

	@Override
	public Hotel addHotel(String hotelName, String address, List<Room>rooms) {

		Hotel addHotel = new Hotel();
		addHotel.setHotelName(hotelName);
		addHotel.setAddress(address);
		addHotel.setRooms(rooms);
		hotelRepository.save(addHotel);
		return addHotel;
	}

	@Override
	public Set<Guest> findAllGuestsLivingInHotel(Long hotelId) {

		Set<Guest> findAllGuests = hotelRepository.findAllGuestsLivingInHotel(hotelId);

		return findAllGuests;

	}

	@Override
	public List<Guest> findAllGuestsCheckedOutTodayInHotel(Long hotelId) {

		List<Guest> guestsCheckedOut = new ArrayList<>();
		List<Guest> guests = hotelRepository.findAllGuestsCheckedOutTodayInHotel(hotelId);
		for (Guest guest : guests) {
			if (guest.getCheckoutDateTime()!=null) {

				guestsCheckedOut.add(guest);
			}

		}
		return guestsCheckedOut;

	}

	public void validateHotelId(Long hotelId) {

		if (hotelId < 0) {

			throw new InvalidHotelIdException("id should not be negative");
		}
	}

	public void validateHotelName(String hotelName) {

		if (hotelName == null || hotelName.isEmpty() || hotelName.trim().isEmpty()) {

			throw new InvalidHotelNameException("name can't be null or empty");
		}
	}

}
