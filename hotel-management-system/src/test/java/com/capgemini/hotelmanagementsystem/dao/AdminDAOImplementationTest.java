package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is AdminDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class AdminDAOImplementationTest {

	static final Logger log = Logger.getLogger(AdminDAOImplementationTest.class);
	AdminDAO adminDAO = Factory.getAdminDAOImplementationInstance();

	/**
	 * This method is used to test admin login
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Admin Valid Login")
	void testAdminLoginTest() {
		log.info("*************Test Case For Admin Valid Login*************\n");
		assertEquals(true, adminDAO.adminLogin());
	}

}
