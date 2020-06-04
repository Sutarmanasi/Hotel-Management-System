package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;

/**
 * This is AdminBean class and here we declared variables and written getter setter
 * methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class AdminBean implements Serializable{

	private String adminUsername;
	private String adminPassword;

	/**
	 * This method is used to get adminUsername
	 * 
	 * @param Nothing
	 * @return adminUsername {@code String}
	 */
	public String getAdminUsername() {
		return adminUsername;
	}

	/**
	 * This method is used to set adminUsername
	 * 
	 * @param adminUsername {@code String}
	 * @return Nothing
	 */
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	/**
	 * This method is used to get adminPassword
	 * 
	 * @param Nothing
	 * @return adminPassword {@code String}
	 */
	public String getAdminPassword() {
		return adminPassword;
	}

	/**
	 * This method is used to set adminPassword
	 * 
	 * @param adminPassword {@code String}
	 * @return Nothing
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/**
	 * This method is used to display adminUsername and adminPassword
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Username = " + adminUsername + "\nPassword = " + adminPassword + "\n";
	}
}
