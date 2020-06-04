package com.capgemini.hotelmanagementsystem.service;

import com.capgemini.hotelmanagementsystem.controller.HotelManagementSystemController;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is HotelManagementSystemService class and implements
 * HotelManagementSystemService
 * 
 * @author Manasi Sutar
 */
public class HotelManagementSystemServiceImplementation implements HotelManagementSystemService {
	/**
	 * This method is used to call hotelManagementServiceSystem method
	 * 
	 * @param Nothing
	 * @return {@code true} if
	 *         {@code object is created and call hotelManagementServiceSystem method},
	 *         otherwise {@code false}
	 */
	public boolean hotelManagementService() {

		HotelManagementSystemController controller = Factory.getHotelManagementSystemControllerInstance();
		return controller.hotelManagementSystem();
	}
}
