package com.cg.apps.hotel_booking.guestms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.apps.hotel_booking.guestms.entities.*;

public interface IGuestTransactionRepository extends JpaRepository<GuestTransaction,Long> {

}
