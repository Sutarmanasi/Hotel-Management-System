package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is EmployeeNotFoundException class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {

	static final Logger log = Logger.getLogger(EmployeeNotFoundException.class);

	String message = "Employee Not Found";

	/**
	 * This method is used to display message
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String getMessage() {
		return message;
	}
}
