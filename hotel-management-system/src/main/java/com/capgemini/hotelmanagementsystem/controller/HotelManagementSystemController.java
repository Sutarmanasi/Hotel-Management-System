package com.capgemini.hotelmanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.service.AdminService;
import com.capgemini.hotelmanagementsystem.service.CustomerService;
import com.capgemini.hotelmanagementsystem.service.EmployeeService;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * The HotelManagementSystemController program implements an application that
 * help us to book hotel, order food, register, login, perform some operations
 *
 * @author Manasi Sutar
 */
public class HotelManagementSystemController {

	static final Logger log = Logger.getLogger(HotelManagementSystemController.class);
	static Scanner scanner = new Scanner(System.in);
	InputValidation inputValidation = Factory.getInputValidationInstance();

	/**
	 * This method is used to check whether user is admin or employee or customer
	 * 
	 * @return Nothing
	 */
	public boolean hotelManagementSystem() {

		do {
			log.info("***********************Please tell us, who are you?***********************\n");
			log.info("1. Admin \n2. Employee \n3. Customer \n4. Exit\n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateHotelManagement(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 4)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);
			switch (choice1) {

			case 1:
				log.info("***********************WELCOME TO HOTEL MANAGEMENT SYSTEM***********************\n");
				log.info("Admin access\n");
				AdminService adminService = Factory.getAdminServiceImplementationInstance();
				adminService.adminService();
				break;

			case 2:
				log.info("***********************WELCOME TO HOTEL MANAGEMENT SYSTEM***********************\n");
				log.info("Employee access\n");
				EmployeeService employeeService = Factory.getEmployeeServiceImplementationInstance();
				employeeService.employeeService();
				break;

			case 3:
				log.info("***********************WELCOME TO OUR PORTAL***********************\n");
				log.info("Customer access\n");
				CustomerService customerService = Factory.getCustomerServiceImplementationInstance();
				customerService.customerService();
				break;

			case 4:
				log.info("***********************Thank You For Using Our Portal***********************\n");
				break;
			default:
				log.error("Please enter valid input\n");
				break;
			}
			break;
		} while (true);
		return true;
	}

	/**
	 * This is the main method which makes use of hotelManagementSystem method
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 */
	public static void main(String[] args) {

		log.info("***********************WELCOME***********************\n");
		log.info("***********************HOTEL MANAGEMENT SYSTEM***********************\n");

		HotelManagementSystemController controller = Factory.getHotelManagementSystemControllerInstance();
		controller.hotelManagementSystem();

	}
}
