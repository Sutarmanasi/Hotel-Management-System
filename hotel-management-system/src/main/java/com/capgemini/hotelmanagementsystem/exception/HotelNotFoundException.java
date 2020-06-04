package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is HotelNotFoundException class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class HotelNotFoundException extends RuntimeException {

	static final Logger log = Logger.getLogger(HotelNotFoundException.class);

	String message = "Hotel Not Found ";

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
