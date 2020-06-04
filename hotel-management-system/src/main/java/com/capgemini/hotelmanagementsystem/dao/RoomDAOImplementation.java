package com.capgemini.hotelmanagementsystem.dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.RoomAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.RoomNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is RoomDAOImplementation class and implements RoomDAO
 * 
 * @author Manasi Sutar
 */
public class RoomDAOImplementation implements RoomDAO {

	static List<RoomBean> roomList = RequestRepository.getRoomRepositoryInstance().roomDetails();
	InputValidation inputValidation = Factory.getInputValidationInstance();

	/**
	 * This method is used to display rooms
	 * 
	 * @param Nothing
	 * @return list<RoomBean>
	 */
	public List<RoomBean> getAllRoomDetails() {
		
		final Logger log = Logger.getLogger(RoomDAOImplementation.class);
		for (RoomBean room : roomList) {
			log.info(room + "\n");
		}
		return roomList;
	}

	/**
	 * This method is used to add room
	 * 
	 * @exception RoomAlreadyExistException
	 * @param room1 {@code Object}
	 * @return {@code true} if {@code room added successfully} , otherwise
	 *         {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean addRoom(RoomBean room1) {
		
		final Logger log = Logger.getLogger(RoomDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		RoomBean room = Factory.getRoomBeanInstance();

		log.info("Please enter room number (Room Number must 3 digit)\n");
		String roomNumber1 = scanner.nextLine();
		while (!inputValidation.roomNumberValidation(roomNumber1)) {
			log.error("Please enter valid  room number (Room Number must 3 digit)\n");
			roomNumber1 = scanner.nextLine();
		}
		int roomNumber = Integer.parseInt(roomNumber1);
		int flag = 0;
		for (RoomBean room2 : roomList) {
			if (room2.getRoomNumber() == roomNumber) {
				flag++;
			}
		}
		if (flag == 1) {
			throw new RoomAlreadyExistException();
		}

		log.info("Please enter room type (Single/Double)\n");
		log.info("1. Single \n2. Double\n");
		String roomTypeChoice = scanner.nextLine();
		while (!inputValidation.choiceValidation(roomTypeChoice)) {
			log.error("Please select 1 or 2");
			roomTypeChoice = scanner.nextLine();
		}
		int roomType = Integer.parseInt(roomTypeChoice);
		switch (roomType) {
		case 1:
			room.setRoomType("Single");
			log.info("Please enter AC or Non AC\n");
			log.info("1. AC \n2. Non AC \n");
			String acOrNonAc = scanner.nextLine();
			while (!inputValidation.choiceValidation(acOrNonAc)) {
				log.error("Please select 1 or 2");
				acOrNonAc = scanner.nextLine();
			}
			int acOrNonAc1 = Integer.parseInt(acOrNonAc);
			if (acOrNonAc1 == 1) {
				room.setAcOrNonAc("AC");
			} else {
				room.setAcOrNonAc("Non AC");
			}

			break;

		case 2:
			room.setRoomType("Double");
			log.info("Please enter AC or Non AC\n");
			log.info("1. AC \n2. Non AC \n");
			String acOrNonAc2 = scanner.nextLine();
			while (!inputValidation.choiceValidation(acOrNonAc2)) {
				log.error("Please select 1 or 2");
				acOrNonAc2 = scanner.nextLine();
			}
			int acOrNonAc3 = Integer.parseInt(acOrNonAc2);
			if (acOrNonAc3 == 1) {
				room.setAcOrNonAc("AC");
			} else {
				room.setAcOrNonAc("Non AC");
			}
			break;

		default:
			log.info("Please enter valid input\n");
			break;
		}

		room.setRoomNumber(roomNumber);
		ArrayList<RoomBean> roomList1 = new ArrayList<RoomBean>();
		roomList1.add(room);
		roomList.addAll(roomList1);
		if (roomList1.isEmpty()) {
			log.error("New room details are not added\n");
			return false;
		} else {
			log.info("New  room details are added \n");
			return true;
		}
	}

	/**
	 * This method is used to delete room
	 * 
	 * @exception RoomNotFoundException
	 * @param roomNumber1 {@code int}
	 * @return {@code true} if {@code room deleted successfully} , otherwise
	 *         {@code false}
	 */
	public boolean deleteRoom(int roomNumber) {
		
		final Logger log = Logger.getLogger(RoomDAOImplementation.class);
		int flag = 0;
		Iterator<RoomBean> room = roomList.iterator();
		while (room.hasNext()) {
			RoomBean str = room.next();
			if (str.getRoomNumber() == roomNumber) {
				flag++;
				room.remove();
				log.info("Data deleted successfully\n");
				return true;
			}
		}
		if (flag == 0) {
			throw new RoomNotFoundException();
		}
		return false;
	}

	/**
	 * This method is used to update room
	 * 
	 * @exception RoomNotFoundException
	 * @param roomean {@code object}
	 * @return {@code true} if {@code room updated successfully} , otherwise
	 *         {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean updateRoom(RoomBean roomBean) {
		
		final Logger log = Logger.getLogger(RoomDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		Factory.getRoomDAOImplementationInstance().getAllRoomDetails();
		log.info("Please enter room number which you need to update \n");
		String roomNumber1 = scanner.nextLine();
		while (!inputValidation.roomNumberValidation(roomNumber1)) {
			log.error("Please enter valid  room number (Room Number must 3 digit)\n");
			roomNumber1 = scanner.nextLine();
		}
		int roomNumber2 = Integer.parseInt(roomNumber1);

		for (RoomBean room1 : roomList) {
			if (room1.getRoomNumber() == roomNumber2) {

				log.info("Request Accepted\n");
				log.info("Please update details here\n");
				log.info("1. Room Number \n" + "2. Room Type \n" + "3. AC or Non AC \n" + "4. Exit \n");
				String choice = scanner.nextLine();
				while (!inputValidation.choiceUpdateRoomValidate(choice)) {
					log.error("Please enter from  1 - 4 \n");
					choice = scanner.nextLine();
				}

				int choice1 = Integer.parseInt(choice);

				switch (choice1) {
				case 1:
					log.info("Please enter room number (Room Number must 3 digit)\n");
					String roomNumber4 = scanner.nextLine();
					while (!inputValidation.roomNumberValidation(roomNumber4)) {
						log.error("Please enter valid  room number (Room Number must 3 digit)\n");
						roomNumber4 = scanner.nextLine();
					}
					int roomNumber3 = Integer.parseInt(roomNumber4);
					room1.setRoomNumber(roomNumber3);
					log.info("Data Updated Successfully\n");

					break;

				case 2:
					log.info("Please enter room type (Single/ Double)\n");
					log.info("1. Single\n2. Double\n");
					String roomType = scanner.nextLine();
					while (!inputValidation.choiceValidation(choice)) {
						log.error("Please enter valid choice (Please select 1 or 2)\n");
						choice = scanner.nextLine();
					}
					int roomType1 = Integer.parseInt(roomType);
					if (roomType1 == 1) {
						room1.setRoomType("Single");
					} else {
						room1.setRoomType("Double");
					}
					log.info("Data Updated Successfully\n");

					break;

				case 3:
					log.info("Please enter AC or Non AC\n");
					log.info("1. AC \n2. Non AC \n");
					String acOrNonAc = scanner.nextLine();
					while (!inputValidation.choiceValidation(acOrNonAc)) {
						log.error("Please enter valid choice (Please select 1 or 2)\n");
						acOrNonAc = scanner.nextLine();
					}
					int acOrNonAc1 = Integer.parseInt(acOrNonAc);
					if (acOrNonAc1 == 1) {
						room1.setRoomType("AC");
					} else {
						room1.setRoomType("Non AC");
					}
					log.info("Data Updated Successfully\n");

					break;

				case 4:
					Factory.getAdminDAOImplementationInstance().operateRoomDetails();
					break;
				}
				return true;
			} else {
				throw new RoomNotFoundException();
			}
		}
		return false;
	}
}
