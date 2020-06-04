package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is CustomerNotFoundException class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {

	static final Logger log = Logger.getLogger(CustomerNotFoundException.class);
	String message = "Customer Not Found ";

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
