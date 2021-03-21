package com.cg.apps.hotel_booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.hotel_booking.HotelBookingApplication;
import com.cg.apps.hotel_booking.hotelms.ui.HotelUI;

@SpringBootApplication
public class HotelBookingApplication {

	private static final Logger Log = LoggerFactory.getLogger(HotelBookingApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(HotelBookingApplication.class, args);
		HotelUI hotelUI = context.getBean(HotelUI.class);
		hotelUI.start();

		Log.debug("i am logged using debug level");
		Log.info("i am logged using info level");
		Log.error("i am logged using error level");
	}

}
