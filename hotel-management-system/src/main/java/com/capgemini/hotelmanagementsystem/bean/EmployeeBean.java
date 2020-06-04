package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The EmployeeBean class is bean class and here we declared variables and
 * written getter setter methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class EmployeeBean implements Serializable {

	private String employeeName;
	private String employeeEmail;
	private long employeeContactNumber;
	private String employeeUsername;
	private String employeePassword;
	private String workingHotelName;
	private LocalDate dob;
	private double salary;

	/**
	 * This method is used to get employeeName
	 * 
	 * @param Nothing
	 * @return employeeName {@code String}
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * This method is used to set employeeName
	 * 
	 * @param employeeName {@code String}
	 * @return Nothing
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * This method is used to get employeeEmail
	 * 
	 * @param Nothing
	 * @return employeeEmail {@code String}
	 */
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	/**
	 * This method is used to set employeeEmail
	 * 
	 * @param employeeEmail {@code String}
	 * @return Nothing
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	/**
	 * This method is used to get employeeContactNumber
	 * 
	 * @param Nothing
	 * @return employeeContactNumber {@code long}
	 */
	public long getEmployeeContactNumber() {
		return employeeContactNumber;
	}

	/**
	 * This method is used to set employeeContactNumber
	 * 
	 * @param employeeContactNumber {@code long}
	 * @return Nothing
	 */
	public void setEmployeeContactNumber(long contactNumber) {
		this.employeeContactNumber = contactNumber;
	}

	/**
	 * This method is used to get employeeUsername
	 * 
	 * @param Nothing
	 * @return employeeUsername {@code String}
	 */
	public String getEmployeeUsername() {
		return employeeUsername;
	}

	/**
	 * This method is used to set employeeUsername
	 * 
	 * @param employeeUsername {@code String}
	 * @return Nothing
	 */
	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	/**
	 * This method is used to get employeePassword
	 * 
	 * @param Nothing
	 * @return employeePassword {@code String}
	 */
	public String getEmployeePassword() {
		return employeePassword;
	}

	/**
	 * This method is used to set employeePassword
	 * 
	 * @param employeePassowrd {@code String}
	 * @return Nothing
	 */
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	/**
	 * This method is used to get workingHotelName
	 * 
	 * @param Nothing
	 * @return workingHotelName {@code String}
	 */
	public String getWorkingHotelName() {
		return workingHotelName;
	}

	/**
	 * This method is used to set workingHotelName
	 * 
	 * @param workingHotelName {@code String}
	 * @return Nothing
	 */
	public void setWorkingHotelName(String workingHotelName) {
		this.workingHotelName = workingHotelName;
	}

	/**
	 * This method is used to get dob
	 * 
	 * @param Nothing
	 * @return dob {@code LocalDate}
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * This method is used to set dob
	 * 
	 * @param dob {@code LocalDate}
	 * @return Nothing
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * This method is used to get salary
	 * 
	 * @param Nothing
	 * @return salary {@code double}
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * This method is used to set salary
	 * 
	 * @param salary {@code double}
	 * @return Nothing
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * This method is used to display employeeUsername and employeePassword
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Employee Name = " + employeeName + "\nEmployee Email Id = " + employeeEmail
				+ "\nEmployee Contact Number = " + employeeContactNumber + "\nEmployee username = " + employeeUsername
				+ "\nWorking Hotel Name = " + workingHotelName + "\nEmployee Date of birth = " + dob + "\nSalary = "
				+ salary + "\n";
	}
}
