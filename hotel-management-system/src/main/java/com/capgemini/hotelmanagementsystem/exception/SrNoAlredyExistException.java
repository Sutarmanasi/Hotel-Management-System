package com.capgemini.hotelmanagementsystem.exception;

import org.apache.log4j.Logger;

/**
 * This is SrNoAlredyExist class and here we throw exception
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class SrNoAlredyExistException extends RuntimeException {

	static final Logger log = Logger.getLogger(SrNoAlredyExistException.class);
	String message = "SrNo Already Exist";

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
