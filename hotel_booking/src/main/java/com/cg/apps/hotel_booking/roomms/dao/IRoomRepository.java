package com.cg.apps.hotel_booking.roomms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

import com.cg.apps.hotel_booking.roomms.entities.*;

public interface IRoomRepository extends JpaRepository<Room, Long> {

	@Query("from Room where floorNum=:floorNumArgs and roomNum=:roomNumArgs")
	List<Room> findByFloorNumAndRoomNum(@Param("floorNumArgs") int floorNum, @Param("roomNumArgs") int roomNum);

}
