package com.capgemini.hotelmanagementsystem.dao;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.EmployeeBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.EmployeeNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.FoodAlredyExistException;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.HotelRepository;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.service.HotelManagementSystemService;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is EmployeeDAOImplementation class and implements EmployeeDAO
 * 
 * @author Manasi Sutar
 */
public class EmployeeDAOImplementation implements EmployeeDAO {

	InputValidation inputValidation = Factory.getInputValidationInstance();
	static List<EmployeeBean> employeeList = RequestRepository.getEmployeeRepositoryInstance().employeeDetails();
	static List<HotelBean> hotelList = new HotelRepository().hotelDetails();
	Properties p = new Properties();

	/**
	 * This method is used to do employee login
	 * 
	 * @exception FileNotFoundException
	 * @param Nothing
	 * @return {@code true} if {@code login successfully} , otherwise {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean employeeLogin() {

		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		String username;
		String password;

		EmployeeBean employee = Factory.getEmployeeBeanInstance();

		try {
			p.load(new FileInputStream(
					"F:/Manu/Engineering/Placement/Capgemini/Project/hotel-management-system/db.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String employeeUsername = p.getProperty("employeeUsername");
		String employeePassword = p.getProperty("employeePassword");

		employee.setEmployeeUsername(employeeUsername);
		employee.setEmployeePassword(employeePassword);

		employeeList.add(employee);

		log.info("***********************Please enter your login details***********************\n");
		log.info("Employee Username : \n");
		username = scanner.nextLine();
		log.info("Employee Password : \n");
		password = scanner.nextLine();
		int flag = 0;
		for (EmployeeBean employeeBean1 : EmployeeDAOImplementation.employeeList) {

			if (employeeBean1.getEmployeeUsername().equals(username) && employeeBean1.getEmployeePassword().equals(password)) {
				flag = 1;
			} else if (employeeBean1.getEmployeeUsername().equals(username)
					|| employeeBean1.getEmployeePassword().equals(password)) {
				flag = 2;
			}
		}
		if (flag == 1) {
			log.info("Login Successfully\n");
			Factory.getEmployeeDAOImplementationInstance().loginEmployeeOperations();
			return true;
		} else if (flag == 2) {
			log.error("Please check your username or password\n");
			employeeLogin();
			return false;
		} else {
			log.error("Login failed\n");
			log.error("Please try again....\n");
			log.info("Do you want to register? (press yes to continue)");
			String yesno = scanner.nextLine();
			if (yesno.equals("yes")) {
				try {
					registerEmployee(Factory.getEmployeeBeanInstance());
					employeeLogin();
				} catch (HotelNotFoundException e) {
					log.info(e.getMessage());
					employeeLogin();
				}
				return false;
			} else {
				Factory.getHotelManagementSystemServiceImplementationInstance().hotelManagementService();
				return false;
			}
		}
	}

	/**
	 * This method is used to perform employee operations before login
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code employee option choose}, otherwise
	 *         {@code false}
	 */
	public boolean employeeOperation() {

		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		do {
			log.info("***********************What you need to access ?***********************\n");
			log.info("1. Employee Login \n2. Employee Register \n3. Exit \n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateEmployee(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 3)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {
			case 1:
				employeeLogin();
				break;

			case 2:
				try {
					registerEmployee(Factory.getEmployeeBeanInstance());
					employeeOperation();
				} catch (HotelNotFoundException e) {
					log.info(e.getMessage());
					employeeOperation();
				}
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
	 * This method is used to perform employee login operations
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code login success} , otherwise {@code false}
	 */
	public boolean loginEmployeeOperations() {

		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		do {
			log.info("***********************Which operation you need to perform ?***********************\n");
			log.info(
					"1. Booking for hotel \n2. View food menu \n3. Add food menu \n4. View Customer List \n5. Update Employee Information \n6. View Food order List \n7. Logout \n");

			String choice = scanner.nextLine();
			while (!inputValidation.choiceValidateEmployeeOperation(choice)) {
				log.error("Please enter valid choice (Choice should be 1 to 7)\n");
				choice = scanner.nextLine();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {
			case 1:
				Factory.getBookingDAOImplementationInstance().addBooking(Factory.getBookingBeanInstance());
				loginEmployeeOperations();
				break;

			case 2:
				Factory.getFoodDAOImplementationInstance().getFoodMenu();
				loginEmployeeOperations();
				break;

			case 3:
				try {
					Factory.getFoodDAOImplementationInstance().addFood(Factory.getFoodBeanInstance());
					loginEmployeeOperations();
				} catch (SrNoAlredyExistException e) {
					log.info(e.getMessage());
					loginEmployeeOperations();
				} catch (FoodAlredyExistException e) {
					log.info(e.getMessage());
					loginEmployeeOperations();
				}
				break;

			case 4:
				Factory.getCustomerDAOImplementationInstance().getAllCustomer();
				loginEmployeeOperations();
				break;

			case 5:
				try {
					Factory.getEmployeeDAOImplementationInstance()
							.updateEmployeeInformation(Factory.getEmployeeBeanInstance());
					loginEmployeeOperations();
				} catch (EmployeeNotFoundException e) {
					log.info(e.getMessage());
					loginEmployeeOperations();
				}
				break;

			case 6:
				Factory.getFoodOrderDAOImplementationInstance().getFoodOrderList();
				loginEmployeeOperations();
				break;

			case 7:
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
	 * This method is used to do registration of employee
	 * 
	 * @exception HotelNotFoundException
	 * @param employeeRegistration {@code Object}
	 * @return {@code true} if {@code registration done}, otherwise {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean registerEmployee(EmployeeBean employeeBean) {

		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		EmployeeBean employeeBean1 = new EmployeeBean();

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
					"Please enter valid  password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
			password = scanner.nextLine();
		}

		log.info("Please enter working hotel name\n");
		String workingHotelName = scanner.nextLine();
		while (!inputValidation.stringValidation(workingHotelName)) {
			log.error("Please enter valid  hotel name \n");
			workingHotelName = scanner.nextLine();
		}
		int flag = 0;
		for (HotelBean hotel2 : hotelList) {
			if (hotel2.getHotelName().equals(workingHotelName)) {
				flag++;
			}
		}
		if (flag == 0) {
			throw new HotelNotFoundException();
		}

		log.info("Please enter date of birth ( Ex: YYYY-MM-DD )\n");
		String dob = scanner.nextLine();
		while (!inputValidation.dateValidation(dob)) {
			log.error("Please enter valid date ( Ex: YYYY-MM-DD )\n ");
			dob = scanner.nextLine();
		}

		LocalDate dob1 = LocalDate.parse(dob);

		log.info("Please enter your salary (Salary must be 4-5 digit)\n");
		String salary = scanner.nextLine();
		while (!inputValidation.salaryValidation(salary)) {
			log.error("Please enter valid date (Salary must be 4-5 digit)\n ");
			salary = scanner.nextLine();
		}
		double salary1 = Double.parseDouble(salary);

		employeeBean1.setEmployeeName(name);
		employeeBean1.setEmployeeEmail(email);
		employeeBean1.setEmployeeContactNumber(contactNumber1);
		employeeBean1.setEmployeeUsername(username);
		employeeBean1.setEmployeePassword(password);
		employeeBean1.setWorkingHotelName(workingHotelName);
		employeeBean1.setDob(dob1);
		employeeBean1.setSalary(salary1);

		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		list.add(employeeBean1);
		employeeList.addAll(list);
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
	 * This method is used to do update employee details
	 * 
	 * @exception EmployeeNotFoundException
	 * @param employeeRegistrationBean {@code Object}
	 * @return {@code true} if {@code updated successfully}, otherwise {@code false}
	 */
	public boolean updateEmployeeInformation(EmployeeBean employeeBean) {

		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);

		log.info("Please enter username which you need to update \n");
		String username = scanner.nextLine();
		while (!inputValidation.usernameValidation(username)) {
			log.error("Please enter valid  username (Username may contain alphabets, number, - , _)\n");
			username = scanner.nextLine();
		}

		int flag = 0;
		for (EmployeeBean employeeBean1 : employeeList) {
			if (employeeBean1.getEmployeeUsername().equals(username)) {
				flag++;
				log.info("Request Accepted\n");
				log.info("Please update details here\n");
				log.info("1. Employee Name \n" + "2. Employee Email \n" + "3. Employee Contact Number \n"
						+ "4. Employee Username \n" + "5. Employee Password \n" + "6. Working Hotel Name \n"
						+ "7. Date of Birth \n" + "8. Salary \n" + "9. Exit \n");
				String choice = scanner.nextLine();
				while (!inputValidation.choiceUpdateEmployeeInformationValidate(choice)) {
					log.error("Please enter from  1 - 9 \n");
					choice = scanner.nextLine();
				}

				int choice1 = Integer.parseInt(choice);

				switch (choice1) {
				case 1:
					log.info("Please update employee name (Name must contain firstname and lastname)\n");
					String employeeName1 = scanner.nextLine();
					while (!inputValidation.nameValidation(employeeName1)) {
						log.error("Please enter valid name (Name must contain firstname and lastname)\n");
						employeeName1 = scanner.nextLine();
					}
					employeeBean1.setEmployeeName(employeeName1);
					log.info("Data Updated Successfully\n");
					break;

				case 2:
					log.info("Please update employee email (Email must contain @gmail. )\n");
					String email = scanner.nextLine();
					while (!inputValidation.emailValidation(email)) {
						log.error("Please enter valid  email (Email must contain @gmail. )\n");
						email = scanner.nextLine();
					}
					employeeBean1.setEmployeeEmail(email);
					log.info("Data Updated Successfully\n");
					break;

				case 3:
					log.info(
							"Please update contact number (Contact number must 10 digits and start from 7 or 8 or 9)\n");
					String contactNumber = scanner.nextLine();
					while (!inputValidation.contactNumberValidation(contactNumber)) {
						log.error(
								"Please enter valid contact number (Contact number must 10 digits and start from 7 or 8 or 9)\n ");
						contactNumber = scanner.nextLine();
					}
					long employeeContactNumber = Long.parseLong(contactNumber);
					employeeBean1.setEmployeeContactNumber(employeeContactNumber);
					log.info("Data Updated Successfully\n");
					break;

				case 4:
					log.info("Please update username (Username may contain alphabets, number, - , _)\n");
					String username1 = scanner.nextLine();
					while (!inputValidation.usernameValidation(username1)) {
						log.error("\n Please enter valid  username (Username may contain alphabets, number, - , _)\n");
						username = scanner.nextLine();
					}
					employeeBean1.setEmployeeUsername(username);
					log.info("Data Updated Successfully\n");
					break;

				case 5:
					log.info(
							"Please update password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
					String password = scanner.nextLine();
					while (!inputValidation.passwordValidation(password)) {
						log.error(
								"Please enter valid  password (Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
						password = scanner.nextLine();
					}
					employeeBean1.setEmployeePassword(password);
					log.info("Data Updated Successfully\n");
					break;

				case 6:
					log.info("Please update working hotel name\n");
					String workingHotelName = scanner.nextLine();
					while (!inputValidation.stringValidation(workingHotelName)) {
						log.error("Please enter valid  hotel name \n");
						workingHotelName = scanner.nextLine();
					}
					employeeBean1.setWorkingHotelName(workingHotelName);
					log.info("Data Updated Successfully\n");
					break;

				case 7:
					log.info("Please enter date of birth ( Ex: YYYY-MM-DD )\n");
					String dob = scanner.nextLine();
					while (!inputValidation.dateValidation(dob)) {
						log.error("Please enter valid date ( Ex: YYYY-MM-DD )\n");
						dob = scanner.nextLine();
					}

					LocalDate dob1 = LocalDate.parse(dob);
					employeeBean1.setDob(dob1);
					log.info("Data Updated Successfully\n");
					break;

				case 8:
					log.info("Please enter your salary (Salary must be 4-5 digit)\n");
					String salary = scanner.nextLine();
					while (!inputValidation.salaryValidation(salary)) {
						log.error("Please enter valid date (Salary must be 4-5 digit)\n ");
						salary = scanner.nextLine();
					}
					double salary1 = Double.parseDouble(salary);
					employeeBean1.setSalary(salary1);
					log.info("Data Updated Successfully\n");
					break;

				case 9:
					Factory.getEmployeeDAOImplementationInstance().loginEmployeeOperations();
					break;
				}
				scanner.close();
			}
		}
		if (flag == 0) {
			throw new EmployeeNotFoundException();
		}
		return false;
	}

	/**
	 * This method is used to do display employee list
	 * 
	 * @param Nothing
	 * @return list<EmployeeBean>
	 */
	public List<EmployeeBean> getAllEmployees() {

		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);

		log.info("***********************List of Employees***********************\n");
		for (EmployeeBean employeeBean : employeeList) {
			log.info(employeeBean + "\n");
		}
		return employeeList;
	}

	/**
	 * This method is used to do display employee list
	 * 
	 * @param hotelName {@code String}
	 * @return list<EmployeeBean>
	 */
	@Override
	public List<EmployeeBean> getEmployeeForSpecificHotel(String hotelName) {
		final Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		int flag = 0;
		for (EmployeeBean employeeBean : employeeList) {
			if (employeeBean.getWorkingHotelName().equals(hotelName)) {
				flag = 1;
				List<EmployeeBean> searchEmployee = new ArrayList<EmployeeBean>();
				searchEmployee.add(employeeBean);
				log.info(searchEmployee + "\n");
			}
		}
		if (flag == 0) {
			throw new EmployeeNotFoundException();
		}
		return null;
	}
}
