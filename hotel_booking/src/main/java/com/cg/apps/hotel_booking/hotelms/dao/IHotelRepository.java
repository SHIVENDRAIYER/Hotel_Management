package com.cg.apps.hotel_booking.hotelms.dao;

import com.cg.apps.hotel_booking.hotelms.entities.*;
import java.util.*;
import com.cg.apps.hotel_booking.guestms.entities.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHotelRepository extends JpaRepository<Hotel, Long> {
	
	@Query("from Guest g join g.room r join r.hotel h where h.hotelId=:hotelId")
	Set<Guest>findAllGuestsLivingInHotel(@Param("hotelId") Long hotelId );
	
	@Query("from Guest g join g.room r join r.hotel h where h.hotelId=:hotelId")
	List<Guest>findAllGuestsCheckedOutTodayInHotel(@Param("hotelId") Long hotelId );

}
