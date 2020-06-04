package com.capgemini.hotelmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is AdminServiceImplementationTest class
 * 
 * @author Manasi Sutar
 */
class AdminServiceImplementationTest {

	HotelManagementSystemService hotelManagementSystemService = Factory
			.getHotelManagementSystemServiceImplementationInstance();

	/**
	 * This method is used to test admin login operations
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	void testHotelManagementSystemService() {
		assertEquals(true, hotelManagementSystemService.hotelManagementService());
	}
}
