package com.cg.apps.hotel_booking.roomms.service;

import com.cg.apps.hotel_booking.hotelms.dao.*;
import com.cg.apps.hotel_booking.hotelms.entities.*;
import com.cg.apps.hotel_booking.hotelms.exceptions.*;
import java.util.*;
import javax.transaction.Transactional;
import com.cg.apps.hotel_booking.roomms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.hotel_booking.roomms.dao.IRoomRepository;
import com.cg.apps.hotel_booking.roomms.exceptions.*;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private IRoomRepository roomRepository;

	@Autowired
	private IHotelRepository hotelRepository;

	@Transactional
	@Override
	public Room addRoom(Long hotelId, int floorNum, int roomNum, double cost) {

		Room room = new Room();
		Optional<Hotel> option = hotelRepository.findById(hotelId);
		if (!option.isPresent()) {

			throw new HotelNotFoundException("Hotel doesnt exist for hotelId: " + hotelId);
		}

		Hotel hotel = option.get();
		room.setHotel(hotel);
		room.setFloorNum(floorNum);
		room.setRoomNum(roomNum);
		room.setAvailable(true);
		room.setCost(cost);

		Room roomAdded = roomRepository.save(room);
		List<Room> rooms = hotel.getRooms();
		if (rooms == null) {

			rooms = new ArrayList<>();
			hotel.setRooms(rooms);
		}

		rooms.add(room);
		hotelRepository.save(hotel);
		return roomAdded;
	}

	@Override
	public Room findById(Long roomId) {

		Optional<Room> optional = roomRepository.findById(roomId);
		if (!optional.isPresent()) {

			throw new RoomNotFoundException("Room not found with roomId: " + roomId);
		}
		return optional.get();
	}

	@Override
	public Room findRoom(Long hotelId, int floorNum, int roomNum) {

		int count = 0;
		Room findRoom = null;
		List<Room> rooms = roomRepository.findByFloorNumAndRoomNum(floorNum, roomNum);
		for (Room room : rooms) {

			if (hotelId == room.getHotel().getHotelId()) {

				count++;
				findRoom = room;

			}
		}
		if (count==0) {

			throw new RoomNotFoundException("Room Not Found");
		}
		return findRoom;
	}

	@Override
	public List<Room> findAllRoomsInHotel(Long hotelId) {

		Optional<Hotel> option = hotelRepository.findById(hotelId);
		if (!option.isPresent()) {

			throw new HotelNotFoundException("Hotel Not Found");
		}

		Hotel hotel = option.get();

		return hotel.getRooms();

	}

	@Override
	public List<Room> availableRoomsInHotel(Long hotelId) {

		List<Room> availableRooms = new ArrayList<>();

		List<Room> rooms = findAllRoomsInHotel(hotelId);

		for (Room room : rooms) {

			if (room.getAvailable()) {

				availableRooms.add(room);
			}
		}

		return availableRooms;
	}

	public void validateRoomId(Long roomId) {

		if (roomId < 0) {

			throw new InvalidRoomIdException("Invalid Room Id");
		}
	}

	public void validateRoomNumber(int roomNo) {

		if (roomNo < 0) {

			throw new InvalidRoomNumberException("Invalid Room Number");
		}
	}

	public void validateFloorNumber(int floorNo) {

		if (floorNo < 0) {

			throw new InvalidFloorNumberException("Invalid Floor Number");
		}
	}

}
