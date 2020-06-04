package com.capgemini.hotelmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is HotelManagementSystemServiceTest class
 * 
 * @author Manasi Sutar
 */
class HotelManagementSystemServiceTest {

	HotelManagementSystemService hotelManagementSystemService = Factory
			.getHotelManagementSystemServiceImplementationInstance();

	/**
	 * This method is used to test admin, customer, employee login operations
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	void testHotelManagementSystemService() {
		assertEquals(true, hotelManagementSystemService.hotelManagementService());
	}

}
