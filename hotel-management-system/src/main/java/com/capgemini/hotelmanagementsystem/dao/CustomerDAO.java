package com.capgemini.hotelmanagementsystem.dao;

import java.io.FileNotFoundException;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.CustomerBean;
import com.capgemini.hotelmanagementsystem.exception.CustomerNotFoundException;

/**
 * This is CustomerDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface CustomerDAO {
	/**
	 * This method is used to do customer login
	 * 
	 * @exception FileNotFoundException
	 * @param Nothing
	 * @return {@code true} if {@code login successfully} , otherwise {@code false}
	 */
	public boolean customerLogin();

	/**
	 * This method is used to perform customer operations before login
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code customer option choose}, otherwise
	 *         {@code false}
	 */
	public boolean customerOperation();

	/**
	 * This method is used to perform customer login operations
	 * 
	 * @param Nothing
	 * @return {@code true} if {@code login success} , otherwise {@code false}
	 */
	public boolean loginCustomerOperations();

	/**
	 * This method is used to do registration of customer
	 * 
	 * @param customerRegistration {@code Object}
	 * @return {@code true} if {@code registration done} , otherwise {@code false}
	 */
	public boolean registerCustomer(CustomerBean customerBean);

	/**
	 * This method is used to do display customer list
	 *
	 * @exception CustomerNotFoundException
	 * @param Nothing
	 * @return list<CustomerRegistrationBean>
	 */
	public List<CustomerBean> getAllCustomer();

	/**
	 * This method is used to do update customer details
	 * 
	 * @exception CustomerNotFoundException
	 * @param customerRegistrationBeanF {@code Oject}
	 * @return {@code true} if {@code updated successfully}, otherwise {@code false}
	 */
	public boolean updateCustomerInformation(CustomerBean customerBean);

}
