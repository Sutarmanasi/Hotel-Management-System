package com.capgemini.hotelmanagementsystem.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is BookingRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */

public class BookingRepository {

	/**
	 * This method is used to set bookingDetails
	 * 
	 * @param Nothing
	 * @return list<BookingBean>
	 */

	public List<BookingBean> bookingDetails() {

		List<BookingBean> bookList = new ArrayList<BookingBean>();

		BookingBean booking = Factory.getBookingBeanInstance();

		booking.setHotelName("TajHotel");
		booking.setBookingDate(LocalDate.of(2020, 04, 23));
		booking.setName("Manasi Sutar");
		booking.setAddress("Banglore");
		booking.setEmail("manasi14@gmail.com");
		booking.setContactNumber(7083788695l);
		booking.setRoomType("Single");
		booking.setNoOfPerson(2);
		booking.setIdProof("Adhar Card");
		booking.setPaymentMethod("Card Payment");

		BookingBean booking1 = Factory.getBookingBeanInstance();

		booking1.setHotelName("DypHotel");
		booking1.setBookingDate(LocalDate.of(2020, 04, 25));
		booking1.setName("Gayatri Sutar");
		booking1.setAddress("Solapur");
		booking1.setEmail("gayatri26@gmail.com");
		booking1.setContactNumber(9623973982l);
		booking1.setRoomType("Single");
		booking1.setNoOfPerson(1);
		booking1.setIdProof("Adhar Card");
		booking1.setPaymentMethod("Cash On Delivery");

		BookingBean booking2 = Factory.getBookingBeanInstance();

		booking2.setHotelName("TajHotel");
		booking2.setBookingDate(LocalDate.of(2020, 04, 25));
		booking2.setName("Apurva Sutar");
		booking2.setAddress("Mumbai");
		booking2.setEmail("apurva23@gmail.com");
		booking2.setContactNumber(9823973982l);
		booking2.setRoomType("Double");
		booking2.setNoOfPerson(3);
		booking2.setIdProof("Adhar Card");
		booking2.setPaymentMethod("Card Payment");

		BookingBean booking3 = Factory.getBookingBeanInstance();

		booking3.setHotelName("DypHotel");
		booking3.setBookingDate(LocalDate.of(2020, 04, 23));
		booking3.setName("Atharv Sutar");
		booking3.setAddress("Pune");
		booking3.setEmail("atharv30@gmail.com");
		booking3.setContactNumber(9028802697l);
		booking3.setRoomType("Single");
		booking3.setNoOfPerson(2);
		booking3.setIdProof("Adhar Card");
		booking3.setPaymentMethod("Cash On Delivery");

		bookList.add(booking);
		bookList.add(booking1);
		bookList.add(booking2);
		bookList.add(booking3);

		return bookList;

	}

}
