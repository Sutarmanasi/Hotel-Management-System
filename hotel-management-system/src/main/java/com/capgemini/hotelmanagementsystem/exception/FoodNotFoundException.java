package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is FoodNotFoundException class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class FoodNotFoundException extends RuntimeException {

	static final Logger log = Logger.getLogger(FoodNotFoundException.class);

	String message = "Food Not Found";

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
