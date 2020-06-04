package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is HotelAlreadyExist class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class HotelAlreadyExistException extends RuntimeException {

	static final Logger log = Logger.getLogger(HotelAlreadyExistException.class);
	String message = "Hotel Already Exist";

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
