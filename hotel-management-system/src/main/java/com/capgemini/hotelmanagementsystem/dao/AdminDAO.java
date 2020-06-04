package com.capgemini.hotelmanagementsystem.dao;

import java.io.FileNotFoundException;

/**
 * This is AdminDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface AdminDAO {
	/**
	 * This method is used to do admin login
	 * 
	 * @exception FileNotFoundException
	 * @param Nothing
	 * @return {@code true} if {@code login successfully} , otherwise {@code false}
	 */
	public boolean adminLogin();

	/**
	 * This method is used to perform admin login operations
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code login success}, otherwise {@code false}
	 */
	public boolean loginAdminOperations();

	/**
	 * This method is used to perform CRUD operation on hotel
	 * 
	 * @param Nothing
	 * @return {@code true} if operations on hotel perform successfully, otherwise
	 *         {@code false}
	 */
	public boolean operateHotelDetails();

	/**
	 * This method is used to perform CRUD operation on room
	 * 
	 * @param Nothing
	 * @return {@code true} if operations on room perform successfully, otherwise
	 *         {@code false}
	 */
	public boolean operateRoomDetails();
}
