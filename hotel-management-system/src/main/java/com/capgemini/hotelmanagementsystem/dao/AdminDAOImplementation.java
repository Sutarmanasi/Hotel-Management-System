package com.capgemini.hotelmanagementsystem.dao;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.AdminBean;
import com.capgemini.hotelmanagementsystem.exception.DateNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.HotelAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.RoomAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.RoomNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.service.HotelManagementSystemService;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is AdminDAOImplementation is class and it implements AdminDAO
 * 
 * @author Manasi Sutar
 */
public class AdminDAOImplementation implements AdminDAO {

	InputValidation inputValidation = Factory.getInputValidationInstance();
	static List<AdminBean> adminlist = new ArrayList<AdminBean>();
	Properties p = new Properties();

	/**
	 * This method is used to do admin login
	 * 
	 * @exception FileNotFoundException
	 * @param Nothing
	 * @return {@code true} if {@code login successfully} , otherwise {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean adminLogin() {

		final Logger log = Logger.getLogger(AdminDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		try {
			p.load(new FileInputStream(
					"F:/Manu/Engineering/Placement/Capgemini/Project/hotel-management-system/db.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String adminUsername = p.getProperty("adminUsername");
		String adminPassword = p.getProperty("adminPassword");
		AdminBean admin = Factory.getAdminBeanInstance();

		admin.setAdminUsername(adminUsername);
		admin.setAdminPassword(adminPassword);

		adminlist.add(admin);

		log.info("***********************Please enter your login details***********************\n");
		log.info("Admin Username : \n");
		username = scanner.nextLine();
		log.info("Admin Password : \n");
		password = scanner.nextLine();

		int flag = 0;
		for (AdminBean admin1 : adminlist) {
			if (admin1.getAdminUsername().equals(username) && admin1.getAdminPassword().equals(password)) {
				flag = 1;
			} else if (admin1.getAdminUsername().equals(username) || admin1.getAdminPassword().equals(password)) {
				flag = 2;
			}
		}
		if (flag == 1) {
			log.info("Login Successfully\n");
			loginAdminOperations();
			return true;
		} else if (flag == 2) {
			log.error("Please check your username or password\n");
			adminLogin();
			return false;
		} else {
			log.error("Login failed\n");
			log.error("Please try again....\n");

			Factory.getHotelManagementSystemServiceImplementationInstance().hotelManagementService();
			return true;
		}
	}

	/**
	 * This method is used to perform admin login operations
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code login success} , otherwise {@code false}
	 */
	@Override
	public boolean loginAdminOperations() {

		final Logger log = Logger.getLogger(AdminDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		do {
			log.info("***********************What you need to access ?***********************\n");
			log.info(
					"1. View List of Hotels \n2. View Bookings of Specific Hotel \n3. View Guest List of Specific Hotel \n4. View Booking for Specific Date \n5. Operate Hotel Details \n6. Operate Room Details \n7. View List Of Employees \n8. View List of Customers \n9. Logout\n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateAdminOperation(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 9)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {
			case 1:
				log.info("***********************List Of Hotels***********************\n");
				Factory.getHotelDAOImplementationInstance().getAllHotelDetails();
				break;

			case 2:
				log.info("***********************Booking List For Specific Hotel***********************\n");
				do {
					log.info("Please select hotel for which guest list you required ?\n");
					Factory.getHotelDAOImplementationInstance().getAllHotelDetails();
					log.info("Please enter hotel name\n");
					String hotelName = scanner.nextLine();
					while (!inputValidation.stringValidation(hotelName)) {
						log.error("Please enter valid  hotel name\n");
						hotelName = scanner.nextLine();
					}

					try {
						Factory.getBookingDAOImplementationInstance().getBookingDetailsForSpecificHotel(hotelName);
						loginAdminOperations();
					} catch (HotelNotFoundException e) {
						log.info(e.getMessage());
						loginAdminOperations();
					}
					break;

				} while (true);
				break;

			case 3:
				log.info("***********************Guest List For Specific Hotel***********************\n");
				do {
					log.info("Please select hotel for which guest list you required ?\n");
					Factory.getHotelDAOImplementationInstance().getAllHotelDetails();
					log.info("Please enter hotel name\n");
					String hotelName = scanner.nextLine();
					while (!inputValidation.stringValidation(hotelName)) {
						log.error("Please enter valid  hotel name\n");
						hotelName = scanner.nextLine();
					}

					try {
						Factory.getBookingDAOImplementationInstance().getBookingDetailsForSpecificHotel(hotelName);
						loginAdminOperations();
					} catch (HotelNotFoundException e) {
						log.info(e.getMessage());
						loginAdminOperations();
					}
					break;

				} while (true);

				break;

			case 4:
				log.info("***********************Booking Details For Specific Date***********************\n");

				do {
					log.info("Please enter date ?( Ex: YYYY-MM-DD )\n");
					String date = scanner.nextLine();
					while (!inputValidation.dateValidation(date)) {
						log.error("Please enter valid date ( Ex: YYYY-MM-DD )\n");
						date = scanner.nextLine();
					}
					LocalDate bookingDate = null;
					try {
						bookingDate = LocalDate.parse(date);
					} catch (Exception e) {
					}
					try {
						Factory.getBookingDAOImplementationInstance().getBookingDetailsForSpecificDate(bookingDate);
						loginAdminOperations();
					} catch (DateNotFoundException e) {
						log.info(e.getMessage());
						loginAdminOperations();
					}
					break;
				} while (true);
				break;

			case 5:
				operateHotelDetails();
				break;
			case 6:
				operateRoomDetails();
				break;

			case 7:
				Factory.getEmployeeDAOImplementationInstance().getAllEmployees();
				loginAdminOperations();
				break;

			case 8:
				Factory.getCustomerDAOImplementationInstance().getAllCustomer();
				loginAdminOperations();
				break;

			case 9:
				log.info("Logout Successfully\n");
				HotelManagementSystemService service = Factory.getHotelManagementSystemServiceImplementationInstance();
				service.hotelManagementService();
				break;
			}
			scanner.close();
			break;
		} while (true);
		return true;
	}

	/**
	 * This method is used to perform CRUD operation on hotel
	 * 
	 * @param Nothing
	 * @return {@code true} if operations on room perform successfully, otherwise
	 *         {@code false}
	 */
	@Override
	public boolean operateHotelDetails() {

		final Logger log = Logger.getLogger(AdminDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		log.info("***********************Operate Hotel Details***********************\n");

		do {
			log.info("Please select, which operation you need to perform?\n");
			log.info("1. Add Hotel \n2. Delete Hotel \n3. Update Hotel \n4. Exit \n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateOperateHotelDetails(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 4)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);
			switch (choice1) {

			case 1:
				log.info("***********************Add Hotel Details***********************\n");
				try {
					Factory.getHotelDAOImplementationInstance().addHotel(Factory.getHotelBeanInstance());
					operateHotelDetails();
				} catch (SrNoAlredyExistException e) {
					log.info(e.getMessage());
					operateHotelDetails();
				} catch (HotelAlreadyExistException e) {
					log.info(e.getMessage());
					operateHotelDetails();
				}
				break;

			case 2:
				log.info("***********************Delete Hotel Details***********************\n");
				Factory.getHotelDAOImplementationInstance().getAllHotelDetails();
				log.info("Please enter hotel name which you want to delete\n");
				String hotelName = scanner.nextLine();
				while (!inputValidation.stringValidation(hotelName)) {
					log.error("Please enter valid  hotel name \n");
					hotelName = scanner.nextLine();
				}
				try {
					Factory.getHotelDAOImplementationInstance().deleteHotel(hotelName);
					operateHotelDetails();
				} catch (HotelNotFoundException e) {
					log.info(e.getMessage() + "[" + hotelName + "]\n");
					operateHotelDetails();
				}

				break;

			case 3:
				log.info("***********************Update Hotel Details***********************\n");
				try {
					Factory.getHotelDAOImplementationInstance().updateHotel(Factory.getHotelBeanInstance());
					operateHotelDetails();
				} catch (HotelNotFoundException e) {
					log.info(e.getMessage());
					operateHotelDetails();
				}
				break;

			case 4:
				loginAdminOperations();
				break;

			default:
				log.error("Please enter valid input\n");
				break;
			}
			scanner.close();
			break;
		} while (true);
		return false;
	}

	/**
	 * This method is used to perform CRUD operation on room
	 * 
	 * @param Nothing
	 * @return {@code true} if operations on room perform successfully, otherwise
	 *         {@code false}
	 */
	@Override
	public boolean operateRoomDetails() {

		final Logger log = Logger.getLogger(AdminDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		log.info("***********************Operate Room Details***********************\n");

		do {
			log.info("Please select, which operation you need to perform?\n");
			log.info("1. Add Room \n2. Delete Room \n3. Update Room \n4. All Room Details \n5. Exit\n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateOperateRoomDetails(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 5)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {
			case 1:
				log.info("***********************Add Room Details***********************\n");
				try {
					Factory.getRoomDAOImplementationInstance().addRoom(Factory.getRoomBeanInstance());
					operateRoomDetails();
				} catch (RoomAlreadyExistException e) {
					log.info(e.getMessage());
					operateRoomDetails();
				}
				break;

			case 2:
				log.info("***********************Delete Room Details***********************\n");
				Factory.getRoomDAOImplementationInstance().getAllRoomDetails();
				log.info("Please enter room number which you want to delete\n");
				String roomNumber1 = scanner.nextLine();
				while (!inputValidation.roomNumberValidation(roomNumber1)) {
					log.error("Please enter valid  room number (Room Number must 3 digit)\n");
					roomNumber1 = scanner.nextLine();
				}
				int roomNumber = Integer.parseInt(roomNumber1);
				try {
					Factory.getRoomDAOImplementationInstance().deleteRoom(roomNumber);
					operateRoomDetails();
				} catch (RoomNotFoundException e) {
					log.info(e.getMessage() + "[" + roomNumber + "]\n");
					operateRoomDetails();
				}

				break;

			case 3:
				log.info("***********************Update Room Details***********************\n");
				try {
					Factory.getRoomDAOImplementationInstance().updateRoom(Factory.getRoomBeanInstance());
					operateRoomDetails();
				} catch (RoomNotFoundException e) {
					log.info(e.getMessage());
					operateRoomDetails();
				}
				break;

			case 4:
				log.info("***********************Get All Room Details***********************\n");
				Factory.getRoomDAOImplementationInstance().getAllRoomDetails();
				operateRoomDetails();
				break;

			case 5:
				loginAdminOperations();
				break;

			default:
				log.error("Please enter valid input\n");
				break;
			}
			scanner.close();
			break;
		} while (true);
		return false;
	}
}
