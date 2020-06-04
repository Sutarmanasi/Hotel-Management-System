package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;

/**
 * This is HotelBean class and here we declared variables and written getter setter
 * methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class HotelBean implements Serializable{

	private int srNo;
	private String hotelName;
	private String hotelAddress;
	private int noOfRooms;
	private long contactNumber;

	/**
	 * This method is used to get srNo
	 * 
	 * @param Nothing
	 * @return srNo {@code int}
	 */
	public int getSrNo() {
		return srNo;
	}

	/**
	 * This method is used to set srNo
	 * 
	 * @param srNo {@code int}
	 * @return Nothing
	 */
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	/**
	 * This method is used to get hotelName
	 * 
	 * @param Nothing
	 * @return hotelName {@code String}
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * This method is used to set hotelName
	 * 
	 * @param hotelName {@code String}
	 * @return Nothing
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * This method is used to get hotelAddress
	 * 
	 * @param Nothing
	 * @return hotelAddress {@code String}
	 */
	public String getHotelAddress() {
		return hotelAddress;
	}

	/**
	 * This method is used to set hotelAddress
	 * 
	 * @param hotelAddress {@code String}
	 * @return Nothing
	 */
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	/**
	 * This method is used to get noOfRooms
	 * 
	 * @param Nothing
	 * @return noOfRooms {@code int}
	 */
	public int getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * This method is used to set noOfRooms
	 * 
	 * @param noOfRooms {@code String}
	 * @return Nothing
	 */
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	/**
	 * This method is used to get customerContactNumber
	 * 
	 * @param Nothing
	 * @return customerContactNumber {@code long}
	 */
	public long getContactNumber() {
		return contactNumber;
	}

	/**
	 * This method is used to set customerContactNumber
	 * 
	 * @param customerContactNumber {@code long}
	 * @return Nothing
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * This method is used to display hotel details
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Sr.No. = " + srNo + "\nHotel Name = " + hotelName + "\nHotel Address = " + hotelAddress
				+ "\nTotal number of rooms = " + noOfRooms + "\nContact Number = " + contactNumber + "\n";
	}
}
