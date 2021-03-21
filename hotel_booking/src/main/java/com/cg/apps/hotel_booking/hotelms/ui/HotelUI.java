package com.cg.apps.hotel_booking.hotelms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import com.cg.apps.hotel_booking.guestms.service.*;

import com.cg.apps.hotel_booking.roomms.entities.*;
import com.cg.apps.hotel_booking.roomms.exceptions.*;
import com.cg.apps.hotel_booking.guestms.exceptions.*;
import org.springframework.stereotype.Component;
import com.cg.apps.hotel_booking.guestms.entities.*;
import com.cg.apps.hotel_booking.roomms.service.*;
import java.util.*;
import com.cg.apps.hotel_booking.hotelms.service.*;
import com.cg.apps.hotel_booking.hotelms.entities.*;
import com.cg.apps.hotel_booking.hotelms.exceptions.*;

@Component
public class HotelUI {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IRoomService roomService;

	@Autowired
	private IGuestService guestService;

	public void start() {

		try {

			Hotel trident = hotelService.addHotel("Trident", "Nanganallur", null);
			Hotel itc = hotelService.addHotel("Itc", "Chennai", null);
			displayHotel(trident);
			displayHotel(itc);

			Room room1 = roomService.addRoom(trident.getHotelId(), 1, 4, 1000.0);
			Room room2 = roomService.addRoom(itc.getHotelId(), 5, 13, 5000.0);
			displayRoom(room1);
			displayRoom(room2);

			Guest guest1 = guestService.allotRoom("547136632104", "Shivendra", trident.getHotelId(), 4, 1, 1000.0);
			Guest guest2 = guestService.allotRoom("547136632105", "Shiv", itc.getHotelId(), 13, 5, 5000.0);
			displayGuest(guest1);
			displayGuest(guest2);

			Hotel tridentId = hotelService.findById(2L);
			displayHotel(tridentId);

			Room room1Id = roomService.findById(4L);
			displayRoom(room1Id);

			Room findRoom1 = roomService.findRoom(trident.getHotelId(), 1, 4);
			displayRoom(findRoom1);

			List<Room> allRooms = roomService.findAllRoomsInHotel(2L);
			System.out.println(allRooms);

			List<Room> availableRooms = roomService.availableRoomsInHotel(2L);
			System.out.println(availableRooms);

			Set<Guest> allGuestLivingInHotel = hotelService.findAllGuestsLivingInHotel(trident.getHotelId());
			System.out.println(allGuestLivingInHotel);

			Guest checkedOut = guestService.checkout(guest1.getGuestId(), trident.getHotelId(), 4, 1);
			displayGuest(checkedOut);

			List<Guest> allGuestsCheckedOut = hotelService.findAllGuestsCheckedOutTodayInHotel(trident.getHotelId());
			System.out.println(allGuestsCheckedOut);

			List<GuestTransaction> transactionHistory = guestService.transactionsHistory(guest1.getGuestId());
			System.out.println(transactionHistory);

		} catch (HotelNotFoundException e) {

			System.out.println("hotel not found");
			e.printStackTrace();

		} catch (InvalidHotelIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidHotelNameException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (RoomNotFoundException e) {

			System.out.println("room not found");
			e.printStackTrace();

		} catch (InvalidRoomIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidRoomNumberException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidFloorNumberException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (GuestNotFoundException e) {

			System.out.println("guest not found");
			e.printStackTrace();

		} catch (InvalidGuestIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidGuestNameException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Something went wrong!");
			e.printStackTrace();

		}

	}

	public void displayHotel(Hotel hotel) {

		System.out.println("hotel id: " + hotel.getHotelId() + " hotel name: " + hotel.getHotelName() + " address: "
				+ hotel.getAddress());

	}

	public void displayRoom(Room room) {

		System.out.println("room id: " + room.getRoomId() + " room num: " + room.getRoomNum() + " floor num: "
				+ room.getFloorNum() + " available: " + room.getAvailable() + " cost: " + room.getCost());

	}

	public void displayGuest(Guest guest) {

		GuestTransaction guestTransaction = guest.getRecentTransaction();
		System.out.println("guest id: " + guest.getGuestId() + " guest name: " + guest.getGuestName()
				+ " guest aadharId: " + guest.getAadharId() + " guest rentedDateTime: " + guest.getRentedDateTime()
				+ " guest transactionId: " + guestTransaction.getGuestTransactionId() + " guest amount: "
				+ guestTransaction.getAmount() + guestTransaction.getDateTime());

	}

}
