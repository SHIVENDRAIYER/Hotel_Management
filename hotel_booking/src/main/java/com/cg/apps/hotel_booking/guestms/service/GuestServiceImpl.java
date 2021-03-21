package com.cg.apps.hotel_booking.guestms.service;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.cg.apps.hotel_booking.guestms.entities.Guest;
import com.cg.apps.hotel_booking.guestms.entities.GuestTransaction;
import com.cg.apps.hotel_booking.roomms.service.*;
import com.cg.apps.hotel_booking.guestms.dao.*;
import com.cg.apps.hotel_booking.roomms.dao.*;
import com.cg.apps.hotel_booking.guestms.exceptions.*;
import com.cg.apps.hotel_booking.hotelms.exceptions.InvalidHotelIdException;
import com.cg.apps.hotel_booking.hotelms.exceptions.InvalidHotelNameException;
import com.cg.apps.hotel_booking.roomms.entities.*;

@Service
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestRepository guestRepository;

	@Autowired
	private IGuestTransactionRepository guestTransactionRepository;

	@Autowired
	private IRoomRepository roomRepository;

	@Autowired
	private IRoomService roomService;

	@Override
	public Guest findById(Long guestId) {

		Optional<Guest> optional = guestRepository.findById(guestId);
		if (!optional.isPresent()) {

			throw new GuestNotFoundException("No guest found");
		}

		return optional.get();
	}

	@Transactional
	@Override
	public Guest allotRoom(String aadharId, String guestName, Long hotelId, int roomNumber, int floorNumber,
			double rent) {

		Guest guest = new Guest();
		guest.setAadharId(aadharId);
		guest.setGuestName(guestName);
		guest.setRentedDateTime(LocalDateTime.now());

		Room room = roomService.findRoom(hotelId, floorNumber, roomNumber);
		room.setAvailable(false);
		roomRepository.save(room);

		GuestTransaction transaction = new GuestTransaction();
		transaction.setAmount(rent);
		transaction.setDateTime(LocalDateTime.now());
		transaction.setGuest(guest);

		guestTransactionRepository.save(transaction);
		guest.setRecentTransaction(transaction);
		guest.setRoom(room);
		List<GuestTransaction> transactions = guest.getTransactions();
		if (transactions == null) {
			
			transactions = new ArrayList<>();
			guest.setTransactions(transactions);
		}
		transactions.add(transaction);

		guest.setTransactions(transactions);
		guest = guestRepository.save(guest);

		return guest;
	}

	@Override
	public List<GuestTransaction> transactionsHistory(Long guestId) {

		Guest guest = findById(guestId);
		List<GuestTransaction> guestTransactions = guest.getTransactions();

		return guestTransactions;
	}

	@Override
	public Guest checkout(Long guestId, Long hotelId, int roomNumber, int floorNumber) {

		Guest guest = findById(guestId);
		Room room = roomService.findRoom(hotelId, floorNumber, roomNumber);
		room.setAvailable(true);
		roomRepository.save(room);

		guest.setCheckoutDateTime(LocalDateTime.now());
		guestRepository.save(guest);
		return guest;

	}

	public void validateGuestId(Long guestId) {

		if (guestId < 0) {

			throw new InvalidHotelIdException("id should not be negative");
		}
	}

	public void validateGuestName(String guestName) {

		if (guestName == null || guestName.isEmpty() || guestName.trim().isEmpty()) {

			throw new InvalidHotelNameException("name can't be null or empty");
		}
	}

}
