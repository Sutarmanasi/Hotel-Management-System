package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.EmployeeBean;
import com.capgemini.hotelmanagementsystem.exception.EmployeeNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

class EmployeeDAOImplementationTest {

	static final Logger log = Logger.getLogger(EmployeeDAOImplementationTest.class);
	EmployeeDAO employeeDAO = Factory.getEmployeeDAOImplementationInstance();
	EmployeeBean employeeBean = Factory.getEmployeeBeanInstance();

	/**
	 * This method is used to test employee login
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Employee Valid Login")
	void testEmployeeLoginTest() {
		log.info("*************Test Case For Employee Valid Login*************\n");
		assertEquals(true, employeeDAO.employeeLogin());
	}

	/**
	 * This method is used to test employee invalid login
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Employee Invalid Login")
	void testEmployeeLoginTest1() {
		log.info("*************Test Case For Employee Invalid Login*************\n");
		assertEquals(false, employeeDAO.employeeLogin());
	}

	/**
	 * This method is used to test add new employee
	 * 
	 * @exception HotelNotFoundException
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Add New Employee")
	void testAddEmployee() {
		log.info("****************Test Case for Add New Employee****************\n");
		try {
			assertEquals(true, employeeDAO.registerEmployee(employeeBean));
		} catch (HotelNotFoundException e) {
			log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to test update employee details
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Update Employee Details")
	void testUpdateEmployee() {
		log.info("****************Test Case for Update Employee Details****************\n");

		try {
			assertEquals(false, employeeDAO.updateEmployeeInformation(employeeBean));
		} catch (EmployeeNotFoundException e) {
			log.info(e.getMessage());
		}
	}

}
