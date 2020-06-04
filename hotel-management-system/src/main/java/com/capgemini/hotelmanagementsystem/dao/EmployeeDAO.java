package com.capgemini.hotelmanagementsystem.dao;

import java.io.FileNotFoundException;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.EmployeeBean;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;

/**
 * This is EmployeeDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface EmployeeDAO {
	/**
	 * This method is used to do employee login
	 * 
	 * @exception FileNotFoundException
	 * @param Nothing
	 * @return {@code true} if {@code login successfully} , otherwise {@code false}
	 */
	public boolean employeeLogin();

	/**
	 * This method is used to perform employee operations before login
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code employee option choose} , otherwise
	 *         {@code false}
	 */
	public boolean employeeOperation();

	/**
	 * This method is used to perform employee login operations
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code login success} , otherwise {@code false}
	 */
	public boolean loginEmployeeOperations();

	/**
	 * This method is used to do registration of employee
	 * 
	 * @exception HotelNotFoundException
	 * @param employeeBean {@code Object}
	 * @return {@code true} if {@code registration done} , otherwise {@code false}
	 */
	public boolean registerEmployee(EmployeeBean employeeBean);

	/**
	 * This method is used to do update employee details
	 * 
	 * @exception EmployeeNotFoundException
	 * @param employeeBean {@code Object}
	 * @return {@code true} if {@code updated successfully} , otherwise
	 *         {@code false}
	 */
	public boolean updateEmployeeInformation(EmployeeBean employeeBean);

	/**
	 * This method is used to do display employee list
	 * 
	 * @param Nothing
	 * @return list<EmployeeBean>
	 */
	public List<EmployeeBean> getAllEmployees();
	
	/**
	 * This method is used to do display employee list
	 * 
	 * @param hotelName {@code String}
	 * @return list<EmployeeBean>
	 */
	public List<EmployeeBean> getEmployeeForSpecificHotel(String hotelName);
	
}
