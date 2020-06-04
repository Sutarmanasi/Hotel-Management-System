package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;

/**
 * This is FoodOrderBean class and here we declared variables and written getter
 * setter methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class FoodOrderBean implements Serializable{

	private String name;
	private String foodName;
	private int roomNumber;
	private int quantity;

	/**
	 * This method is used to get name
	 * 
	 * @param Nothing
	 * @return name {@code String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is used to set name
	 * 
	 * @param name {@code String}
	 * @return Nothing
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is used to get foodName
	 * 
	 * @param Nothing
	 * @return foodName {@code String}
	 */
	public String getFoodName() {
		return foodName;
	}

	/**
	 * This method is used to set foodName
	 * 
	 * @param foodName {@code String}
	 * @return Nothing
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

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
	 * This method is used to get quantity
	 * 
	 * @param Nothing
	 * @return quantity {@code int}
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * This method is used to set quantity
	 * 
	 * @param quantity {@code int}
	 * @return Nothing
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method is used to display food order details
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Name = " + name + "\nFood Name = " + foodName + "\nRoom Number = " + roomNumber + "\nQuantity = "
				+ quantity + "\n";
	}
}
