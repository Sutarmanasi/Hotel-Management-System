package com.capgemini.hotelmanagementsystem.dao;

import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.BookingBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.DateNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.HotelRepository;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is BookingDAOImplementation class and implements BookingDAO
 * 
 * @author Manasi Sutar
 */
public class BookingDAOImplementation implements BookingDAO {

	static List<BookingBean> bookList = RequestRepository.getBookingRepositoryInstance().bookingDetails();
	static List<HotelBean> hotelList = new HotelRepository().hotelDetails();
	InputValidation inputValidation = Factory.getInputValidationInstance();

	/**
	 * This method is used to display booking list
	 * 
	 * @param Nothing
	 * @return list<Bookingean>
	 */
	@Override
	public List<BookingBean> getBookingDetails() {
		final Logger log = Logger.getLogger(BookingDAOImplementation.class);
		for (BookingBean bookingBean : bookList) {

			log.info(bookingBean);
		}
		return bookList;

	}

	/**
	 * This method is used to book hotel
	 * 
	 * @exception HotelNotFoundException
	 * @param bookingBean {@code Object}
	 * @return {@code true} if {@code booking successful} is {@code booking failed},
	 *         otherwise {@code false}
	 */
	@Override
	@SuppressWarnings("resource")
	public boolean addBooking(BookingBean bookingBean) {

		final Logger log = Logger.getLogger(BookingDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		
		log.info("Please select, which hotel you want to book ?\n");
		log.info("Please enter hotel name\n");
		String hotelName = scanner.nextLine();
		while (!inputValidation.stringValidation(hotelName)) {
			log.error("Please enter valid  hotel name \n");
			hotelName = scanner.nextLine();
		}
		int flag = 0;
		for (HotelBean hotel : HotelDAOImplementation.hotelList) {
			if (hotel.getHotelName().equals(hotelName)) {
				flag++;
			}
		}
		if (flag == 0) {
			throw new HotelNotFoundException();
		}
		BookingBean booking = Factory.getBookingBeanInstance();

		booking.setHotelName(hotelName);

		log.info("Please enter booking date ( Ex: YYYY-MM-DD )\n");
		String bookingDate = scanner.nextLine();
		while (!inputValidation.dateValidation(bookingDate)) {
			log.error("Please enter valid booking date ( Ex: YYYY-MM-DD )\n");
			bookingDate = scanner.nextLine();
		}

		Date date1 = null;
		Date date2 = null;

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(bookingDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, -1);

		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(cal.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (date1.compareTo(date2) > 0) {
			LocalDate bookDate = LocalDate.parse(bookingDate);
			booking.setBookingDate(bookDate);
			log.info("Please enter your name (Name must contain firstname and lastname)\n");
			String name = scanner.nextLine();
			while (!inputValidation.nameValidation(name)) {
				log.error("Please enter valid  name (Name must contain firstname and lastname)\n");
				name = scanner.nextLine();
			}
			booking.setName(name);

			log.info("Please enter your address\n");
			String address = scanner.nextLine();
			while (!inputValidation.stringValidation(address)) {
				log.error("Please enter valid  address \n");
				address = scanner.nextLine();
			}
			booking.setAddress(address);

			log.info("Please enter email (Email must contain @gmail. )\n");
			String email = scanner.nextLine();
			while (!inputValidation.emailValidation(email)) {
				log.error("Please enter valid  email (Email must contain @gmail. )\n");
				email = scanner.nextLine();
			}
			booking.setEmail(email);

			log.info("Please enter contact number (Contact Number must 10 digits and start from 7 or 8 or 9)\n");
			String contactNumber = scanner.nextLine();
			while (!inputValidation.contactNumberValidation(contactNumber)) {
				log.error(
						"Please enter valid contact number (Contact Number must 10 digits and start from 7 or 8 or 9)\n");
				contactNumber = scanner.nextLine();
			}

			Long contactNumber1 = Long.parseLong(contactNumber);
			booking.setContactNumber(contactNumber1);

			log.info("Please enter room type (Single/Double)\n");
			log.info("1. Single\n2. Double\n");
			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidation(choice)) {
				log.error("Please enter valid choice (Please select 1 or 2)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);
			switch (choice1) {
			case 1:
				booking.setRoomType("Single");

				log.info("Please enter number of persons\n");
				String noOfPerson1 = scanner.nextLine();
				while (!inputValidation.choiceSingleValidation(noOfPerson1)) {
					log.error("Maximum 2 persons allowed\n");
					noOfPerson1 = scanner.nextLine();
				}
				int noOfPerson = Integer.parseInt(noOfPerson1);
				booking.setNoOfPerson(noOfPerson);
				break;

			case 2:
				booking.setRoomType("Double");

				log.info("Please enter number of persons\n");
				String noOfPerson2 = scanner.nextLine();
				while (!inputValidation.choiceDoubleValidation(noOfPerson2)) {
					log.error("Maximum 4 persons allowed\n");
					noOfPerson2 = scanner.nextLine();
				}
				int noOfPerson3 = Integer.parseInt(noOfPerson2);
				booking.setNoOfPerson(noOfPerson3);
				break;
			}

			log.info("Please enter Id proof (Adhar Card/Driving Licence)\n");
			log.info("1. Adhar Card\n2. Driving Licence\n");
			String choice2 = scanner.nextLine();
			while (!inputValidation.choiceValidation(choice2)) {
				log.error("Please enter valid choice (Please select 1 or 2)\n");
				choice2 = scanner.nextLine();
			}

			int choice3 = Integer.parseInt(choice2);
			switch (choice3) {
			case 1:
				booking.setIdProof("Adhar Card");
				break;

			case 2:
				booking.setIdProof("Driving Licence");
				break;
			}

			log.info("Please enter payment method (Card Payment/Cash Payment)\n");
			log.info("1. Card Payment\n2. Cash Payment\n");
			String choice4 = scanner.nextLine();
			while (!inputValidation.choiceValidation(choice4)) {
				log.error("Please enter valid choice (Please select 1 or 2)\n");
				choice4 = scanner.nextLine();
			}

			int choice5 = Integer.parseInt(choice4);
			switch (choice5) {
			case 1:
				booking.setPaymentMethod("Card Payment");
				break;

			case 2:
				booking.setPaymentMethod("Cash Payment");
				break;
			}
			ArrayList<BookingBean> list = new ArrayList<BookingBean>();
			list.add(booking);
			bookList.addAll(list);
			if (list.isEmpty()) {
				log.error("Booking failed");
				log.error("Please try again....\n");
				return false;
			} else {
				log.info("Booking Successful \n");
				log.info("***********************Thank You For Booking***********************\n");
				return true;
			}
		} else {
			log.error("Please enter date from today's date\n");
			addBooking(Factory.getBookingBeanInstance());
			return true;
		}
	}

	/**
	 * This method is used to display booking list of hotel
	 * 
	 * @exception HotelNotFoundException
	 * @exception BookingNotFoundException
	 * @param hotelName {@code String}
	 * @return list<BookingBean>
	 */
	@Override
	public List<BookingBean> getBookingDetailsForSpecificHotel(String hotelName) {
		final Logger log = Logger.getLogger(BookingDAOImplementation.class);
		int flag = 0;
		for (BookingBean booking : bookList) {
			if (booking.getHotelName().equals(hotelName)) {
				flag = 1;
				List<BookingBean> searchBooking = new ArrayList<BookingBean>();
				searchBooking.add(booking);
				log.info(searchBooking + "\n");
				
			}
		}
		if (flag == 0) {
			throw new HotelNotFoundException();
		} 
		return null;
	}

	/**
	 * This method is used to display booking list for specific date
	 * 
	 * @exception DateNotFoundException
	 * @param booking date {@code LocalDate}
	 * @return list<BookingBean>
	 */
	@Override
	public List<BookingBean> getBookingDetailsForSpecificDate(LocalDate bookingDate) {
		
		final Logger log = Logger.getLogger(BookingDAOImplementation.class);

		int flag = 0;

		for (BookingBean booking : bookList) {
			if (booking.getBookingDate().equals(bookingDate)) {
				flag++;
				List<BookingBean> searchBooking = new ArrayList<BookingBean>();
				searchBooking.add(booking);
				log.info(searchBooking + "\n");

			}
		}
		if (flag == 0) {
			throw new DateNotFoundException();
		}
		return bookList;
	}
}
