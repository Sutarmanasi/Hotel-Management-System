package com.capgemini.hotelmanagementsystem.service;

import com.capgemini.hotelmanagementsystem.dao.CustomerDAO;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is CustomerServiceImplementation class and implements CustomerService
 * 
 * @author Manasi Sutar
 */
public class CustomerServiceImplementation implements CustomerService {
	/**
	 * This method is used to call customer login method
	 * 
	 * @param Nothing
	 * @return {@code true} if
	 *         {@code object is created and call customer login method}, otherwise
	 *         {@code false}
	 */
	public boolean customerService() {

		CustomerDAO customerDAO = Factory.getCustomerDAOImplementationInstance();
		return customerDAO.customerOperation();
	}
}
