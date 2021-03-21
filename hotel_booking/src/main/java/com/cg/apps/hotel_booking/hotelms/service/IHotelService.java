package com.cg.apps.hotel_booking.hotelms.service;

import com.cg.apps.hotel_booking.hotelms.entities.*;
import com.cg.apps.hotel_booking.roomms.entities.*;
import com.cg.apps.hotel_booking.guestms.entities.*;
import java.util.*;

public interface IHotelService {

	Hotel findById(Long hotelId);

	Hotel addHotel(String hotelName, String address, List<Room>rooms);

	Set<Guest> findAllGuestsLivingInHotel(Long hotelId);

    List<Guest> findAllGuestsCheckedOutTodayInHotel(Long hotelId);

}
