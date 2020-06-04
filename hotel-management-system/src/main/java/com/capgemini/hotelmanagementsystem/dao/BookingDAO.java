package com.capgemini.hotelmanagementsystem.dao;

import java.time.LocalDate;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingBean;
import com.capgemini.hotelmanagementsystem.exception.DateNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;

/**
 * This is BookingDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface BookingDAO {
	/**
	 * This method is used to display booking list for specific date
	 * 
	 * @exception DateNotFoundException
	 * @param booking date {@code LocalDate}
	 * @return list<BookingBean>
	 */
	public List<BookingBean> getBookingDetailsForSpecificDate(LocalDate bookingDate);

	/**
	 * This method is used to display booking list
	 * 
	 * @param Nothing
	 * @return list<BookingBean>
	 */
	public List<BookingBean> getBookingDetails();

	/**
	 * This method is used to book hotel
	 * 
	 * @exception HotelNotFoundException
	 * @param bookingBean {@code Object}
	 * @return {@code true} if {@code booking successful} , otherwise {@code false}
	 */
	public boolean addBooking(BookingBean bookingBean);

	/**
	 * This method is used to display booking list of hotel
	 * 
	 * @exception HotelNotFoundException
	 * @exception BookingNotFoundException
	 * @param hotelName {@code String}
	 * @return list<BookingBean>
	 */
	public List<BookingBean> getBookingDetailsForSpecificHotel(String hotelName);

}
