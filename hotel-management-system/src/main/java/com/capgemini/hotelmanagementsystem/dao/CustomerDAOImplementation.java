package com.capgemini.hotelmanagementsystem.dao;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.CustomerBean;
import com.capgemini.hotelmanagementsystem.exception.CustomerNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.FoodNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.RoomNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.service.HotelManagementSystemService;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is CustomerDAOImplementation class and implements CustomerDAO
 * 
 * @author Manasi Sutar
 */
public class CustomerDAOImplementation implements CustomerDAO {

	static List<CustomerBean> customerList = RequestRepository.getCustomerRepositoryInstance()
			.customerDetails();
	InputValidation inputValidation = Factory.getInputValidationInstance();
	Properties p = new Properties();

	/**
	 * This method is used to do customer login
	 * 
	 * @exception FileNotFoundException
	 * @param Nothing
	 * @return {@code true} if {@code login successfully} , otherwise {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean customerLogin() {

		final Logger log = Logger.getLogger(CustomerDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		String username;
		String password;

		CustomerBean customerBean = Factory.getCustomerBeanInstance();
		try {
			p.load(new FileInputStream(
					"F:/Manu/Engineering/Placement/Capgemini/Project/hotel-management-system/db.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String customerUsername = p.getProperty("customerUsername");
		String customerPassword = p.getProperty("customerPassword");

		customerBean.setCustomerUsername(customerUsername);
		customerBean.setCustomerPassword(customerPassword);

		customerList.add(customerBean);

		log.info("***********************Please enter your login details***********************\n");
		log.info("Customer Username : \n");
		username = scanner.nextLine();
		log.info("Customer Password : \n");
		password = scanner.nextLine();
		int flag = 0;
		for (CustomerBean customer1 : customerList) {
			if (customer1.getCustomerUsername().equals(username) && customer1.getCustomerPassword().equals(password)) {
				flag = 1;
			} else if (customer1.getCustomerUsername().equals(username)
					|| customer1.getCustomerPassword().equals(password)) {
				flag = 2;

			}
		}
		if (flag == 1) {
			log.info("Login Successfully\n");
			Factory.getCustomerDAOImplementationInstance().loginCustomerOperations();
			return true;
		} else if (flag == 2) {
			log.error("Please check your username or password\n");
			customerLogin();
			return false;
		} else {
			log.error("Login failed\n");
			log.error("Please try again....\n");
			log.info("Do you want to register? (press yes to continue)");
			String yesno = scanner.nextLine();
			if (yesno.equals("yes")) {
				registerCustomer(Factory.getCustomerBeanInstance());
				customerLogin();
				return false;
			} else {
				Factory.getHotelManagementSystemServiceImplementationInstance().hotelManagementService();
				return false;
			}
		}

	}

	/**
	 * This method is used to perform customer operations before login
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code customer option choose} , otherwise
	 *         {@code false}
	 */
	public boolean customerOperation() {

		final Logger log = Logger.getLogger(CustomerDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		do {
			log.info("***********************What you need to access ?***********************\n");
			log.info("1. Customer Login \n2. Customer Register \n3. Exit \n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateCustomer(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 3)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {
			case 1:
				customerLogin();
				break;

			case 2:
				registerCustomer(Factory.getCustomerBeanInstance());
				break;

			case 3:
				HotelManagementSystemService service = Factory.getHotelManagementSystemServiceImplementationInstance();
				service.hotelManagementService();
				break;
			}
			scanner.close();
			break;
		} while (true);
		return true;
	}

	/**
	 * This method is used to perform customer login operations
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code login success} , otherwise {@code false}
	 */
	public boolean loginCustomerOperations() {

		final Logger log = Logger.getLogger(CustomerDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		do {
			log.info("***********************Which operation you need to perform ?***********************\n");
			log.info(
					"1. Booking for hotel \n2. View food menu \n3. Order Food \n4. Update Customer Information \n5. Logout \n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateCustomerOperation(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 5)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {
			case 1:
				Factory.getBookingDAOImplementationInstance().addBooking(Factory.getBookingBeanInstance());
				loginCustomerOperations();
				break;

			case 2:
				Factory.getFoodDAOImplementationInstance().getFoodMenu();
				loginCustomerOperations();
				break;

			case 3:
				try {
					Factory.getFoodOrderDAOImplementationInstance().addFoodOrder(Factory.getFoodOrderBeanInstance());
					loginCustomerOperations();
				} catch (RoomNotFoundException e) {
					log.info(e.getMessage() + "\n");
					loginCustomerOperations();
				} catch (FoodNotFoundException e) {
					log.info(e.getMessage() + "\n");
					loginCustomerOperations();
				}
				break;

			case 4:
				try {
					updateCustomerInformation(Factory.getCustomerBeanInstance());
					loginCustomerOperations();
				} catch (CustomerNotFoundException e) {
					log.info(e.getMessage());
					loginCustomerOperations();
				}
				break;

			case 5:
				log.info("Logout Successfully\n");
				HotelManagementSystemService service = Factory.getHotelManagementSystemServiceImplementationInstance();
				service.hotelManagementService();
				break;
			}
			scanner.close();
			break;
		} while (true);

		return true;
	}

	/**
	 * This method is used to do registration of customer
	 * 
	 * @param customerRegistration {@code Object}
	 * @return {@code true} if {@code registration done} , otherwise {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean registerCustomer(CustomerBean customerBean) {

		final Logger log = Logger.getLogger(CustomerDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		CustomerBean customerBean1 = new CustomerBean();
		log.info("***********************Please Enter Registration Details***********************\n");

		log.info("Please enter your name (Name must contain firstname and lastname)\n");
		String name = scanner.nextLine();
		while (!inputValidation.nameValidation(name)) {
			log.error("Please enter valid  name (Name must contain firstname and lastname)\n");
			name = scanner.nextLine();
		}

		log.info("Please enter email (Email must contain @gmail. )\n");
		String email = scanner.nextLine();
		while (!inputValidation.emailValidation(email)) {
			log.error("Please enter valid  email (Email must contain @gmail. )\n");
			email = scanner.nextLine();
		}

		log.info("Please enter contact number (Contact Number must 10 digits and start with 7 or 8 or 9)\n");
		String contactNumber = scanner.nextLine();
		while (!inputValidation.contactNumberValidation(contactNumber)) {
			log.error(
					"Please enter valid contact number (Contact Number must 10 digits and start with 7 or 8 or 9)\n ");
			contactNumber = scanner.nextLine();
		}
		Long contactNumber1 = Long.parseLong(contactNumber);

		log.info("Please enter username (Username may contain alphabets, number, - , _)\n");
		String username = scanner.nextLine();
		while (!inputValidation.usernameValidation(username)) {
			log.error("Please enter valid  username (Username may contain alphabets, number, - , _)\n");
			username = scanner.nextLine();
		}

		log.info(
				"Please enter password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
		String password = scanner.nextLine();
		while (!inputValidation.passwordValidation(password)) {
			log.error(
					"Please enter valid password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
			password = scanner.nextLine();
		}

		customerBean1.setCustomerName(name);
		customerBean1.setCustomerEmail(email);
		customerBean1.setCustomerContactNumber(contactNumber1);
		customerBean1.setCustomerUsername(username);
		customerBean1.setCustomerPassword(password);

		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		list.add(customerBean1);
		customerList.addAll(list);
		if (list.isEmpty()) {
			log.error("Registration failed\n");
			log.error("Please try again....\n");
			return false;
		} else {
			log.info("Registration Successful \n");
			log.info("***********************Thank You For Registration***********************\n");
			return true;
		}
	}

	/**
	 * This method is used to do display customer list
	 * 
	 * @param Nothing
	 * @return list<CustomerBean>
	 */
	public List<CustomerBean> getAllCustomer() {

		final Logger log = Logger.getLogger(CustomerDAOImplementation.class);

		log.info("***********************List of Customers***********************\n");
		for (CustomerBean customerBean : customerList) {
			log.info("\n" + customerBean);
		}
		return customerList;
	}

	/**
	 * This method is used to do update customer details
	 * 
	 * @exception CustomerNotFoundException
	 * @param customerRegistrationBeanF {@code Object}
	 * @return {@code true} if {@code updated successfully} , otherwise
	 *         {@code false}
	 */
	public boolean updateCustomerInformation(CustomerBean customerBean) {

		final Logger log = Logger.getLogger(CustomerDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		log.info("Please enter username which you need to update \n");
		String username = scanner.nextLine();
		while (!inputValidation.usernameValidation(username)) {
			log.error("Please enter valid  username (Username may contain alphabets, number, - , _)\n");
			username = scanner.nextLine();
		}
		for (CustomerBean customerBean1 : customerList) {
			if (customerBean1.getCustomerUsername().equals(username)) {
				log.info("Request Accepted\n");
				log.info("Please update details here\n");
				log.info("1. Email Id \n" + "2. Contact Number \n" + "3. Change Password \n" + "4. Exit \n");
				String choice = scanner.nextLine();
				while (!inputValidation.choiceUpdateCustomerDetailsValidate(choice)) {
					log.error("Please enter from  1 - 4 \n");
					choice = scanner.nextLine();
				}

				int choice1 = Integer.parseInt(choice);

				switch (choice1) {
				case 1:
					log.info("Please update email (Email must contain @gmail. )\n");
					String email = scanner.nextLine();
					while (!inputValidation.emailValidation(email)) {
						log.error("Please enter valid  email (Email must contain @gmail. )\n");
						email = scanner.nextLine();
					}
					customerBean1.setCustomerEmail(email);
					log.info("Data Updated Successfully\n");
					break;

				case 2:
					log.info(
							"Please update contact number (Contact Number must 10 digits and start with 7 or 8 or 9)\n");
					String contactNumber = scanner.nextLine();
					while (!inputValidation.contactNumberValidation(contactNumber)) {
						log.error(
								"Please enter valid contact number (Contact Number must 10 digits and start with 7 or 8 or 9)\n");
						contactNumber = scanner.nextLine();
					}
					Long contactNumber1 = Long.parseLong(contactNumber);
					customerBean1.setCustomerContactNumber(contactNumber1);
					log.info("Data Updated Successfully\n");
					break;

				case 3:
					log.info(
							"Please update password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
					String password = scanner.nextLine();
					while (!inputValidation.passwordValidation(password)) {
						log.error(
								"Please enter valid  password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
						password = scanner.nextLine();
					}
					customerBean1.setCustomerPassword(password);
					log.info("Data Updated Successfully\n");
					break;

				case 4:
					Factory.getCustomerDAOImplementationInstance().loginCustomerOperations();
					break;
				}
				scanner.close();
			} else {
				throw new CustomerNotFoundException();
			}
		}
		return false;

	}
}
