package com.cg.apps.hotel_booking.roomms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.apps.hotel_booking.roomms.entities.*;
import com.cg.apps.hotel_booking.roomms.dto.*;
import com.cg.apps.hotel_booking.roomms.util.*;
import com.cg.apps.hotel_booking.roomms.service.*;
import java.util.*;

@RequestMapping("/rooms")
@RestController
public class RoomRestController {

	@Autowired
	private IRoomService roomService;

	@Autowired
	private RoomUtil util;

	@PostMapping("/add")
	public RoomDetails addRoom(@RequestBody RoomAddRequest request) {
		Room room = roomService.addRoom(request.getHotelId(), request.getFloorNum(), request.getRoomNum(),
				request.getCost());
		return util.toDetail(room);
	}

	@GetMapping(value = "/findbyid/{id}")
	public RoomDetails findById(@PathVariable("id") Long roomId) {
		Room room = roomService.findById(roomId);
		return util.toDetail(room);
	}

	@GetMapping("/find")
	public RoomDetails find(@RequestBody RoomFindRequest request) {
		Room room = roomService.findRoom(request.getHotelId(), request.getFloorNum(), request.getRoomNum());
		return util.toDetail(room);
	}

	@GetMapping("/findallrooms/{id}")
	public List<RoomDetails> findAll(@PathVariable("id") Long hotelId) {
		List<Room> rooms = roomService.findAllRoomsInHotel(hotelId);
		return util.toDetailList(rooms);
	}

	@GetMapping("/findallavialablerooms/{id}")
	public List<RoomDetails> findAllAvailable(@PathVariable("id") Long hotelId) {
		List<Room> rooms = roomService.availableRoomsInHotel(hotelId);
		return util.toDetailList(rooms);
	}

}
