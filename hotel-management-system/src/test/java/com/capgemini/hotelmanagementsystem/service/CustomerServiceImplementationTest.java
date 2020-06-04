package com.capgemini.hotelmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is CustomerServiceImplementationTest class
 * 
 * @author Manasi Sutar
 */
class CustomerServiceImplementationTest {

	CustomerService customerService = Factory.getCustomerServiceImplementationInstance();

	/**
	 * This method is used to test customer login operations
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	void testCustomerService() {
		assertEquals(true, customerService.customerService());
	}

}
