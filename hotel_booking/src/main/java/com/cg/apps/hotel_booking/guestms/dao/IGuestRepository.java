package com.cg.apps.hotel_booking.guestms.dao;

import com.cg.apps.hotel_booking.guestms.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestRepository extends JpaRepository<Guest,Long> {

}
