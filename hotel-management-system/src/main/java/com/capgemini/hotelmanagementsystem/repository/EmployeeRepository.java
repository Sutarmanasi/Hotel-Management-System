package com.capgemini.hotelmanagementsystem.repository;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.EmployeeBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is EmployeeRegistrationRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */
public class EmployeeRepository {

	/**
	 * This method is used to set employeeDetails
	 * 
	 * @param Nothing
	 * @return list<EmployeeRegistrationBean>
	 */
	public List<EmployeeBean> employeeDetails() {

		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();

		EmployeeBean employeeBean = Factory.getEmployeeBeanInstance();

		employeeBean.setEmployeeName("Akshay Sutar");
		employeeBean.setEmployeeEmail("akshay19@gmail.com");
		employeeBean.setEmployeeContactNumber(9028802697l);
		employeeBean.setEmployeeUsername("akshay");
		employeeBean.setEmployeePassword("Akshay@30");
		employeeBean.setWorkingHotelName("DypHotel");
		employeeBean.setDob(LocalDate.of(1997, 11, 19));
		employeeBean.setSalary(20000);

		employeeList.add(employeeBean);

		return employeeList;
	}
}
