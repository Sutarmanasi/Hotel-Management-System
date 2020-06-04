package com.capgemini.hotelmanagementsystem.service;

import com.capgemini.hotelmanagementsystem.dao.EmployeeDAO;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is EmployeeServiceImplementation class and implements EmployeeService
 * 
 * @author Manasi Sutar
 */
public class EmployeeServiceImplementation implements EmployeeService {
	/**
	 * This method is used to call employee login method
	 * 
	 * @param Nothing
	 * @return {@code true} if
	 *         {@code object is created and call employee login method}, otherwise
	 *         {@code false}
	 */
	public boolean employeeService() {

		EmployeeDAO employeeDAO = Factory.getEmployeeDAOImplementationInstance();
		return employeeDAO.employeeOperation();
	}
}
