package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;

/**
 * This is FoodBean class and here we declared variables and written getter setter
 * methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */
@SuppressWarnings("serial")
public class FoodBean implements Serializable{

	private int srNo;
	private String foodType;
	private String foodName;

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
	 * This method is used to get foodType
	 * 
	 * @param Nothing
	 * @return foodType {@code String}
	 */
	public String getFoodType() {
		return foodType;
	}

	/**
	 * This method is used to set foodType
	 * 
	 * @param foodType {@code String}
	 * @return Nothing
	 */
	public void setFoodType(String foodType) {
		this.foodType = foodType;
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
	 * This method is used to display food menu
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "SrNo = " + srNo + "\nFood Type = " + foodType + "\nFood Name = " + foodName + "\n";
	}
}
