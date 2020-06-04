package com.capgemini.hotelmanagementsystem.dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.HotelAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is HotelDAOImplementation class and implements HotelDAO
 * 
 * @author Manasi Sutar
 */
public class HotelDAOImplementation implements HotelDAO {

	static List<HotelBean> hotelList = RequestRepository.getHotelRepositoryInstance().hotelDetails();
	InputValidation inputValidation = Factory.getInputValidationInstance();

	/**
	 * This method is used to add hotel
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception HotelAlreadyExistException
	 * @param hotel1 {@code Object}
	 * @return {@code true} if {@code hotel added successfully} , otherwise
	 *         {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean addHotel(HotelBean hotel1) {

		final Logger log = Logger.getLogger(HotelDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		
		HotelBean hotel = Factory.getHotelBeanInstance();

		log.info("Please enter SR.No (2 digit)\n");
		String srNo1 = scanner.nextLine();
		while (!inputValidation.srNoValidation(srNo1)) {
			log.error("Please enter only 2 digits\n");
			srNo1 = scanner.nextLine();
		}
		int srNo = Integer.parseInt(srNo1);
		int flag1 = 0;
		for (HotelBean hotel2 : hotelList) {
			if (hotel2.getSrNo() == srNo) {
				flag1++;
			}
		}
		if (flag1 == 1) {
			throw new SrNoAlredyExistException();
		}

		log.info("Please enter hotel name \n");
		String hotelName = scanner.nextLine();
		while (!inputValidation.stringValidation(hotelName)) {
			log.error("Please enter valid  hotel name \n");
			hotelName = scanner.nextLine();
		}
		int flag = 0;
		for (HotelBean hotel2 : hotelList) {
			if (hotel2.getHotelName().equals(hotelName)) {
				flag++;
			}
		}
		if (flag == 1) {
			throw new HotelAlreadyExistException();
		}
		log.info("Please enter hotel address \n");
		String hotelAddress = scanner.nextLine();
		while (!inputValidation.stringValidation(hotelAddress)) {
			log.error("Please enter valid  address \n");
			hotelAddress = scanner.nextLine();
		}

		log.info("Please enter contact number (Contact number must 10 digits and start from 7 or 8 or 9)\n");
		String contactNumber = scanner.nextLine();
		while (!inputValidation.contactNumberValidation(contactNumber)) {
			log.error(
					"Please enter valid contact number (Contact number must 10 digits and start from 7 or 8 or 9)\n ");
			contactNumber = scanner.nextLine();
		}
		long hotelContactNumber = Long.parseLong(contactNumber);

		log.info("Please enter total number rooms in hotel\n");
		String noOfRooms1 = scanner.nextLine();
		while (!inputValidation.srNoValidation(noOfRooms1)) {
			log.error("Please enter only digits\n");
			noOfRooms1 = scanner.nextLine();
		}
		int noOfRooms = Integer.parseInt(noOfRooms1);

		hotel.setSrNo(srNo);
		hotel.setHotelName(hotelName);
		hotel.setHotelAddress(hotelAddress);
		hotel.setNoOfRooms(noOfRooms);
		hotel.setContactNumber(hotelContactNumber);

		ArrayList<HotelBean> hotelList1 = new ArrayList<HotelBean>();
		hotelList1.add(hotel);
		hotelList.addAll(hotelList1);
		if (hotelList1.isEmpty()) {
			log.error("New hotel details are not added\n");
			log.error("Please try again....\n");
			return false;
		} else {
			log.info("New  hotel details are added \n");
			return true;
		}
	}

	/**
	 * This method is used to delete hotel
	 * 
	 * @exception HotelNotFoundException
	 * @param hotelName {@code String}
	 * @return {@code true} if {@code hotel deleted successfully} , otherwise
	 *         {@code false}
	 */
	public boolean deleteHotel(String hotelName) {
		
		final Logger log = Logger.getLogger(HotelDAOImplementation.class);
		
		int flag = 0;
		Iterator<HotelBean> hotel = hotelList.iterator();
		while (hotel.hasNext()) {
			HotelBean str = hotel.next();
			if (str.getHotelName().equals(hotelName)) {
				flag++;
				hotel.remove();
				log.info("Data deleted successfully\n");
				return true;
			}
		}
		if (flag == 0) {
			throw new HotelNotFoundException();
		}
		return false;
	}

	/**
	 * This method is used to update hotel
	 * 
	 * @exception HotelNotFoundException
	 * @param hotelName {@code String}
	 * @return {@code true} if {@code hotel updated successfully} , otherwise
	 *         {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean updateHotel(HotelBean hotelBean) {
		
		final Logger log = Logger.getLogger(HotelDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		
		Factory.getHotelDAOImplementationInstance().getAllHotelDetails();
		
		log.info("Please enter hotel name which you need to update \n");
		String hotelName1 = scanner.nextLine();
		while (!inputValidation.stringValidation(hotelName1)) {
			log.error("Please enter valid  hotel name \n");
			hotelName1 = scanner.nextLine();
		}
		
		for (HotelBean hotel1 : hotelList) {
			if (hotel1.getHotelName().equals(hotelName1)) {

				log.info("Request Accepted\n");
				log.info("Please update details here\n");
				log.info("1. Hotel Name \n" + "2. Hotel Address \n" + "3. Contact Number \n"
						+ "4. Total number of rooms \n" + "5. Exit \n");
				String choice = scanner.nextLine();
				while (!inputValidation.choiceUpdateHotelValidate(choice)) {
					log.error("Please enter from  1 - 5 \n");
					choice = scanner.nextLine();
				}

				int choice1 = Integer.parseInt(choice);

				switch (choice1) {
				case 1:
					log.info("Please update hotel name \n");
					String hotelName11 = scanner.nextLine();
					while (!inputValidation.stringValidation(hotelName11)) {
						log.error("Please enter valid  hotel name \n");
						hotelName11 = scanner.nextLine();
					}

					hotel1.setHotelName(hotelName11);

					log.info("Data Updated Successfully\n");
					break;

				case 2:
					log.info("Please update hotel address \n");
					String hotelAddress = scanner.nextLine();
					while (!inputValidation.stringValidation(hotelAddress)) {
						log.error("Please enter valid  address \n");
						hotelAddress = scanner.nextLine();
					}
					hotel1.setHotelAddress(hotelAddress);
					log.info("Data Updated Successfully\n");
					break;

				case 3:
					log.info(
							"Please update contact number (Contact number must 10 digits and start from 7 or 8 or 9)\n");
					String contactNumber = scanner.nextLine();
					while (!inputValidation.contactNumberValidation(contactNumber)) {
						log.error(
								"Please enter valid contact number (Contact number must 10 digits and start from 7 or 8 or 9)\n ");
						contactNumber = scanner.nextLine();
					}
					long hotelContactNumber = Long.parseLong(contactNumber);
					hotel1.setContactNumber(hotelContactNumber);
					log.info("Data Updated Successfully\n");
					break;

				case 4:
					log.info("Please update total number rooms in hotel\n");
					String noOfRooms = scanner.nextLine();
					while (!inputValidation.srNoValidation(noOfRooms)) {
						log.error("Please enter only digits\n");
						noOfRooms = scanner.nextLine();
					}
					int noOfRooms1 = Integer.parseInt(noOfRooms);
					hotel1.setNoOfRooms(noOfRooms1);
					log.info("Data Updated Successfully\n");
					break;

				case 5:
					Factory.getAdminDAOImplementationInstance().operateHotelDetails();
					break;
				}
				return true;
			} else {
				throw new HotelNotFoundException();
			}
		}
		return false;
	}

	/**
	 * This method is used to display hotel list
	 * 
	 * @param Nothing
	 * @return list<HotelBean>
	 */
	public List<HotelBean> getAllHotelDetails() {
		
		final Logger log = Logger.getLogger(HotelDAOImplementation.class);
		
		for (HotelBean hotel : hotelList) {
			log.info(hotel);
		}
		return hotelList;
	}

}
