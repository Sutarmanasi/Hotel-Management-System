package com.capgemini.hotelmanagementsystem.repository;

import java.util.ArrayList;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.CustomerBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is CustomerRegistrationRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */
public class CustomerRepository {

	/**
	 * This method is used to set customerDetails
	 * 
	 * @param Nothing
	 * @return list<CustomerRegistrationBean>
	 */
	public List<CustomerBean> customerDetails() {

		List<CustomerBean> customerList = new ArrayList<CustomerBean>();

		CustomerBean customerBean = Factory.getCustomerBeanInstance();

		customerBean.setCustomerName("Apurva Sutar");
		customerBean.setCustomerEmail("apurva23@gmail.com");
		customerBean.setCustomerContactNumber(9823973982l);
		customerBean.setCustomerUsername("apurvasutar");
		customerBean.setCustomerPassword("Dingoo@123");

		customerList.add(customerBean);

		return customerList;
	}
}
