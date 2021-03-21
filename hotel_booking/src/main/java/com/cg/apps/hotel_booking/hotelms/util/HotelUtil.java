package com.cg.apps.hotel_booking.hotelms.util;

import org.springframework.stereotype.Component;
import com.cg.apps.hotel_booking.hotelms.entities.*;
import com.cg.apps.hotel_booking.roomms.entities.*;
import java.util.*;
import com.cg.apps.hotel_booking.hotelms.dto.*;

@Component
public class HotelUtil {

	public HotelDetails toDetails(Hotel hotel) {

		HotelDetails hotelDetails = new HotelDetails();

		hotelDetails.setHotelId(hotel.getHotelId());
		hotelDetails.setHotelName(hotel.getHotelName());
		hotelDetails.setAddress(hotel.getAddress());
		hotelDetails.setRoomIds(null);

		List<Room> rooms = hotel.getRooms();
		if (rooms != null) {

			List<Long> roomIds = new ArrayList<>();
			for (Room room : rooms) {

				Long roomId = room.getRoomId();
				roomIds.add(roomId);
			}

			hotelDetails.setRoomIds(roomIds);
		}

		return hotelDetails;
	}

}
