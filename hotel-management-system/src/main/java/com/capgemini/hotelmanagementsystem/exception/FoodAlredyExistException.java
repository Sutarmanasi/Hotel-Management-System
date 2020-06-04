package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is FoodAlredyExist class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class FoodAlredyExistException extends RuntimeException {

	static final Logger log = Logger.getLogger(FoodAlredyExistException.class);
	String message = "Food Already Exist";

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
