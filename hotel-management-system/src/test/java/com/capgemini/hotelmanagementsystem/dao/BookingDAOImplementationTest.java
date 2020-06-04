package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.BookingBean;
import com.capgemini.hotelmanagementsystem.dao.BookingDAO;
import com.capgemini.hotelmanagementsystem.dao.BookingDAOImplementation;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is BookingDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class BookingDAOImplementationTest {

	static final Logger log = Logger.getLogger(BookingDAOImplementation.class);
	BookingBean booking = Factory.getBookingBeanInstance();

	/**
	 * This method is used to test add booking
	 * 
	 * @exception HotelNotFoundException
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Add Booking")
	void testAddBooking() {
		log.info("****************Test Case for Add Booking****************\n");
		BookingDAO bookingDAO = Factory.getBookingDAOImplementationInstance();
		try {
			assertEquals(true, bookingDAO.addBooking(booking));
		} catch (HotelNotFoundException e) {
			log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to test get booking details
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Get Booking Details")
	void testGetBookingDetails() {
		log.info("****************Test Case for Get Booking Details****************\n");
		BookingDAO bookingDAO = Factory.getBookingDAOImplementationInstance();
		assertNotNull(bookingDAO.getBookingDetails());
	}

	/**
	 * This method is used to test get booking details for specific date
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Booking Details for Specific Date")
	void testBookingDetailsForSpecificDate() {
		log.info("****************Test Case for Booking Details of Specific Date****************\n");
		BookingDAO bookingDAO = Factory.getBookingDAOImplementationInstance();
		assertNotNull(bookingDAO.getBookingDetailsForSpecificDate(LocalDate.of(2020, 04, 25)));
	}

	/**
	 * This method is used to test get booking details for specific hotel
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Booking Details for Specific Hotel")
	void testBookingDetailsForSpecificHotel() {
		log.info("****************Test Case for Booking Details of Specific Hotel****************\n");
		BookingDAO bookingDAO = Factory.getBookingDAOImplementationInstance();
		assertNotNull(bookingDAO.getBookingDetailsForSpecificHotel("TajHotel"));
	}
}
