package com.cg.apps.hotel_booking.roomms.util;

import org.springframework.stereotype.Component;
import com.cg.apps.hotel_booking.roomms.dto.*;
import java.util.*;
import com.cg.apps.hotel_booking.roomms.entities.*;

@Component
public class RoomUtil {

	public RoomDetails toDetail(Room room) {

		RoomDetails roomDetails = new RoomDetails();

		roomDetails.setRoomId(room.getRoomId());
		roomDetails.setRoomNum(room.getRoomNum());
		roomDetails.setFloorNum(room.getFloorNum());
		roomDetails.setAvailable(room.getAvailable());
		roomDetails.setCost(room.getCost());
		roomDetails.setHotelId(room.getHotel().getHotelId());
		roomDetails.setHotelName(room.getHotel().getHotelName());

		return roomDetails;
	}

	public List<RoomDetails> toDetailList(List<Room> rooms) {

		List<RoomDetails> roomDetails = new ArrayList<>();
		for (Room room : rooms) {

			roomDetails.add(toDetail(room));
		}

		return roomDetails;
	}

}
