package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.dao.RoomDAO;
import com.capgemini.hotelmanagementsystem.dao.RoomDAOImplementation;
import com.capgemini.hotelmanagementsystem.exception.RoomAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.RoomNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is RoomDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class RoomDAOImplementationTest {

	static final Logger log = Logger.getLogger(RoomDAOImplementation.class);
	RoomBean room = Factory.getRoomBeanInstance();

	/**
	 * This method is used to test add room
	 * 
	 * @exception RoomAlreadyExistException
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Add New Room")
	void testAddRoom() {
		log.info("****************Test Case for Add New Room****************\n");
		RoomDAO roomDAO = Factory.getRoomDAOImplementationInstance();
		try {
			assertEquals(true, roomDAO.addRoom(room));
		} catch (RoomAlreadyExistException e) {
			log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to test delete room
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Delete Room")
	void testDeleteRoom() {
		log.info("****************Test Case for Delete Room****************\n");
		RoomDAO roomDAO = Factory.getRoomDAOImplementationInstance();
		assertEquals(true, roomDAO.deleteRoom(101));
	}

	/**
	 * This method is used to test update room
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Update Room")
	void testUpdateRoom() {
		log.info("****************Test Case for Update Room****************\n");
		RoomDAO roomDAO = Factory.getRoomDAOImplementationInstance();
		try {
			assertEquals(true, roomDAO.updateRoom(room));
		} catch (RoomNotFoundException e) {
			log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to test get room details
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Get All Room Details")
	void testGetAllRoomDetails() {
		log.info("****************Test Case for Get All Room Details****************\n");
		RoomDAO roomDAO = Factory.getRoomDAOImplementationInstance();
		assertNotNull(roomDAO.getAllRoomDetails());
	}

}
