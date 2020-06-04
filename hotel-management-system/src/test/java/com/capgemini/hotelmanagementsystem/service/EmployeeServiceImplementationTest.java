package com.capgemini.hotelmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is EmployeeServiceImplementationTest class
 * 
 * @author Manasi Sutar
 */
class EmployeeServiceImplementationTest {

	EmployeeService employeeService = Factory.getEmployeeServiceImplementationInstance();

	/**
	 * This method is used to test employee login operations
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	void testEmployeeService() {
		assertEquals(true, employeeService.employeeService());
	}

}
