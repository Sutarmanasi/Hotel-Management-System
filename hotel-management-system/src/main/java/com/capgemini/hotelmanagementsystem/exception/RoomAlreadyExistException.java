package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is RoomAlreadyExist class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class RoomAlreadyExistException extends RuntimeException {

	static final Logger log = Logger.getLogger(RoomAlreadyExistException.class);
	String message = "Room Already Exist";

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
