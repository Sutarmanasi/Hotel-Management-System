package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;

/**
 * This is RoomBean class and here we declared variables and written getter setter
 * methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class RoomBean implements Serializable{

	private int roomNumber;
	private String roomType;
	private String acOrNonAc;

	/**
	 * This method is used to get roomNumber
	 * 
	 * @param Nothing
	 * @return roomNumber {@code int}
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * This method is used to set roomNumber
	 * 
	 * @param roomNumber {@code int}
	 * @return Nothing
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * This method is used to get roomType
	 * 
	 * @param Nothing
	 * @return roomType {@code String}
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * This method is used to set roomType
	 * 
	 * @param roomType {@code String}
	 * @return Nothing
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * This method is used to get room acOrNonAc
	 * 
	 * @param Nothing
	 * @return room acOrNonAc {@code String}
	 */
	public String getAcOrNonAc() {
		return acOrNonAc;
	}

	/**
	 * This method is used to set room acOrNonAc
	 * 
	 * @param room acOrNonAc {@code String}
	 * @return Nothing
	 */
	public void setAcOrNonAc(String acOrNonAc) {
		this.acOrNonAc = acOrNonAc;
	}

	/**
	 * This method is used to display room details
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Room Number = " + roomNumber + "\nRoom Type = " + roomType + "\nAC or Non AC = " + acOrNonAc + "\n";
	}
}
