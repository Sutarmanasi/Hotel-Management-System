package com.capgemini.hotelmanagementsystem.factory;

import com.capgemini.hotelmanagementsystem.bean.AdminBean;

import com.capgemini.hotelmanagementsystem.bean.BookingBean;
import com.capgemini.hotelmanagementsystem.bean.CustomerBean;
import com.capgemini.hotelmanagementsystem.bean.EmployeeBean;
import com.capgemini.hotelmanagementsystem.bean.FoodBean;
import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.controller.HotelManagementSystemController;
import com.capgemini.hotelmanagementsystem.dao.AdminDAO;
import com.capgemini.hotelmanagementsystem.dao.AdminDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.BookingDAO;
import com.capgemini.hotelmanagementsystem.dao.BookingDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.CustomerDAO;
import com.capgemini.hotelmanagementsystem.dao.CustomerDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.EmployeeDAO;
import com.capgemini.hotelmanagementsystem.dao.EmployeeDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.FoodDAO;
import com.capgemini.hotelmanagementsystem.dao.FoodDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.FoodOrderDAO;
import com.capgemini.hotelmanagementsystem.dao.FoodOrderDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.HotelDAO;
import com.capgemini.hotelmanagementsystem.dao.HotelDAOImplementation;
import com.capgemini.hotelmanagementsystem.dao.RoomDAO;
import com.capgemini.hotelmanagementsystem.dao.RoomDAOImplementation;
import com.capgemini.hotelmanagementsystem.service.AdminService;
import com.capgemini.hotelmanagementsystem.service.AdminServiceImplementation;
import com.capgemini.hotelmanagementsystem.service.CustomerService;
import com.capgemini.hotelmanagementsystem.service.CustomerServiceImplementation;
import com.capgemini.hotelmanagementsystem.service.EmployeeService;
import com.capgemini.hotelmanagementsystem.service.EmployeeServiceImplementation;
import com.capgemini.hotelmanagementsystem.service.HotelManagementSystemService;
import com.capgemini.hotelmanagementsystem.service.HotelManagementSystemServiceImplementation;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;
import com.capgemini.hotelmanagementsystem.validation.InputValidationImplementation;

/**
 * This is Factory class and here we create object of other classes
 * 
 * @author Manasi Sutar
 */
public class Factory {
	/**
	 * This method is used to create object of HotelManagementSystemService
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static HotelManagementSystemService getHotelManagementSystemServiceImplementationInstance() {
		return new HotelManagementSystemServiceImplementation();
	}

	/**
	 * This method is used to create object of AdminService
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static AdminService getAdminServiceImplementationInstance() {
		return new AdminServiceImplementation();
	}

	/**
	 * This method is used to create object of EmployeeService
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static EmployeeService getEmployeeServiceImplementationInstance() {
		return new EmployeeServiceImplementation();
	}

	/**
	 * This method is used to create object of CustomerService
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static CustomerService getCustomerServiceImplementationInstance() {
		return new CustomerServiceImplementation();
	}

	/**
	 * This method is used to create object of InputValidation
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static InputValidation getInputValidationInstance() {
		return new InputValidationImplementation();
	}

	/**
	 * This method is used to create object of AdminDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static AdminDAO getAdminDAOImplementationInstance() {
		return new AdminDAOImplementation();
	}

	/**
	 * This method is used to create object of HotelManagementSystemController
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static HotelManagementSystemController getHotelManagementSystemControllerInstance() {
		return new HotelManagementSystemController();
	}

	/**
	 * This method is used to create object of Booking
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static BookingBean getBookingBeanInstance() {
		return new BookingBean();
	}

	/**
	 * This method is used to create object of BookingDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static BookingDAO getBookingDAOImplementationInstance() {
		return new BookingDAOImplementation();
	}

	/**
	 * This method is used to create object of Admin
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static AdminBean getAdminBeanInstance() {
		return new AdminBean();
	}

	/**
	 * This method is used to create object of Hotel
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static HotelBean getHotelBeanInstance() {
		return new HotelBean();
	}

	/**
	 * This method is used to create object of HotelDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static HotelDAO getHotelDAOImplementationInstance() {
		return new HotelDAOImplementation();
	}

	/**
	 * This method is used to create object of Room
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static RoomBean getRoomBeanInstance() {
		return new RoomBean();
	}

	/**
	 * This method is used to create object of RoomDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static RoomDAO getRoomDAOImplementationInstance() {
		return new RoomDAOImplementation();
	}

	/**
	 * This method is used to create object of Employee
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static EmployeeBean getEmployeeBeanInstance() {
		return new EmployeeBean();
	}

	/**
	 * This method is used to create object of Food
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static FoodBean getFoodBeanInstance() {
		return new FoodBean();
	}

	/**
	 * This method is used to create object of FoodDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static FoodDAO getFoodDAOImplementationInstance() {
		return new FoodDAOImplementation();
	}

	/**
	 * This method is used to create object of EmployeeDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static EmployeeDAO getEmployeeDAOImplementationInstance() {
		return new EmployeeDAOImplementation();
	}

	/**
	 * This method is used to create object of FoodOrderDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static FoodOrderDAO getFoodOrderDAOImplementationInstance() {
		return new FoodOrderDAOImplementation();
	}

	/**
	 * This method is used to create object of FoodOrder
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static FoodOrderBean getFoodOrderBeanInstance() {
		return new FoodOrderBean();
	}

	/**
	 * This method is used to create object of Customer
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static CustomerBean getCustomerBeanInstance() {
		return new CustomerBean();
	}

	/**
	 * This method is used to create object of CustomerDAO
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static CustomerDAO getCustomerDAOImplementationInstance() {
		return new CustomerDAOImplementation();
	}

}
