package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.dao.HotelDAO;
import com.capgemini.hotelmanagementsystem.dao.HotelDAOImplementation;
import com.capgemini.hotelmanagementsystem.exception.HotelAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is HotelDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class HotelDAOImplementationTest {

	static final Logger log = Logger.getLogger(HotelDAOImplementation.class);
	HotelBean hotel = Factory.getHotelBeanInstance();

	/**
	 * This method is used to test add hotel
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception HotelAlreadyExistException
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Add New Hotel")
	void testAddHotel() {
		log.info("****************Test Case for Add New Hotel****************\n");
		HotelDAO hotelDAO = Factory.getHotelDAOImplementationInstance();
		try {
			assertEquals(true, hotelDAO.addHotel(hotel));
		} catch (SrNoAlredyExistException e) {
			log.info(e.getMessage());
		} catch (HotelAlreadyExistException e) {
			log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to test delete hotel
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Delete Hotel")
	void testDeleteHotel() {
		log.info("****************Test Case for Delete Hotel****************\n");
		HotelDAO hotelDAO = Factory.getHotelDAOImplementationInstance();
		assertEquals(true, hotelDAO.deleteHotel("TajHotel"));
	}

	/**
	 * This method is used to test update hotel
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Update Hotel")
	void testUpdateHotel() {
		log.info("****************Test Case for Update Hotel****************\n");
		HotelDAO hotelDAO = Factory.getHotelDAOImplementationInstance();
		try {
			assertEquals(true, hotelDAO.updateHotel(hotel));
		} catch (HotelNotFoundException e) {
			log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to test get hotel details
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Get All Hotel Details")
	void testGetAllHotelDetails() {
		log.info("****************Test Case for Get All Hotel Details****************\n");
		HotelDAO hotelDAO = Factory.getHotelDAOImplementationInstance();
		assertNotNull(hotelDAO.getAllHotelDetails());
	}
}
