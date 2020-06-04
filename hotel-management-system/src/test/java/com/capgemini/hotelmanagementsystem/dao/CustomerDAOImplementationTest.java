package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.CustomerBean;
import com.capgemini.hotelmanagementsystem.exception.CustomerNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is CustomerDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class CustomerDAOImplementationTest {

	static final Logger log = Logger.getLogger(CustomerDAOImplementationTest.class);
	CustomerDAO customerDAO = Factory.getCustomerDAOImplementationInstance();
	CustomerBean customerBean = Factory.getCustomerBeanInstance();
	
	/**
	 * This method is used to test customer login
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Customer Valid Login")
	void testCustomerLoginTest() {
		log.info("*************Test Case For Customer Valid Login*************\n");
		assertEquals(true, customerDAO.customerLogin());
	}

	/**
	 * This method is used to test customer invalid login
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Customer Invalid Login")
	void testCustomerLoginTest1() {
		log.info("*************Test Case For Customer Invalid Login*************\n");
		assertEquals(false, customerDAO.customerLogin());
	}

	/**
	 * This method is used to test add new customer
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Add New Customer")
	void testAddCustomer() {
		log.info("****************Test Case for Add New Customer****************\n");
		assertEquals(true, customerDAO.registerCustomer(customerBean));
	}

	/**
	 * This method is used to test update customer
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Update Customer Details")
	void testUpdateCustomer() {
		log.info("****************Test Case for Update Customer Details****************\n");
		try {
			assertEquals(false, customerDAO.updateCustomerInformation(customerBean));
		} catch (CustomerNotFoundException e) {
			log.info(e.getMessage());
		}
	}
}
