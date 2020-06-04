package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;

/**
 * The CustomerBean class is bean class and here we declared variables and
 * written getter setter methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class CustomerBean implements Serializable {

	private String customerName;
	private String customerEmail;
	private long customerContactNumber;
	private String customerUsername;
	private String customerPassword;

	/**
	 * This method is used to get customerName
	 * 
	 * @param Nothing
	 * @return customerName {@code String}
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * This method is used to set customerName
	 * 
	 * @param customerName {@code String}
	 * @return Nothing
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * This method is used to get customerEmail
	 * 
	 * @param Nothing
	 * @return customerEmail {@code String}
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * This method is used to set customerEmail
	 * 
	 * @param customerEmail {@code String}
	 * @return Nothing
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * This method is used to get customerContactNumber
	 * 
	 * @param Nothing
	 * @return customerContactNumber {@code long}
	 */
	public long getCustomerContactNumber() {
		return customerContactNumber;
	}

	/**
	 * This method is used to set customerContactNumber
	 * 
	 * @param customerContactNumber {@code long}
	 * @return Nothing
	 */
	public void setCustomerContactNumber(long customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	/**
	 * This method is used to get customerUsername
	 * 
	 * @param Nothing
	 * @return customerUsername {@code String}
	 */
	public String getCustomerUsername() {
		return customerUsername;
	}

	/**
	 * This method is used to set customerUsername
	 * 
	 * @param customerUsername {@code String}
	 * @return Nothing
	 */
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	/**
	 * This method is used to get customerPassword
	 * 
	 * @param Nothing
	 * @return customerPassword {@code String}
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * This method is used to set customerPassword
	 * 
	 * @param customerPassword {@code String}
	 * @return Nothing
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * This method is used to display customerUsername and customerPassword
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Customer Name = " + customerName + "\nCustomer Email Id = " + customerEmail
				+ "\nCustomer Contact Number = " + customerContactNumber + "\nCustomer username = " + customerUsername
				+ "\n";
	}
}
