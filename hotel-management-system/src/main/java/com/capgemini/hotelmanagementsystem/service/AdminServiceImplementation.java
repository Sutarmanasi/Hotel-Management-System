package com.capgemini.hotelmanagementsystem.service;

import com.capgemini.hotelmanagementsystem.dao.AdminDAO;

import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is AdminServiceImplementation class and implements AdminService
 * 
 * @author Manasi Sutar
 */
public class AdminServiceImplementation implements AdminService {
	/**
	 * This method is used to call admin login method
	 * 
	 * @param Nothing
	 * @return {@code true} if
	 *         {@code object is created and call admin login method}, otherwise
	 *         {@code false}
	 */
	public boolean adminService() {
		AdminDAO adminDAO = Factory.getAdminDAOImplementationInstance();
		return adminDAO.adminLogin();
	}
}
