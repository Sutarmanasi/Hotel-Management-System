package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.FoodBean;
import com.capgemini.hotelmanagementsystem.exception.FoodAlredyExistException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;

/**
 * This is FoodDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface FoodDAO {
	/**
	 * This method is used to add food
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception FoodAlredyExistException
	 * @param food {@code Object}
	 * @return {@code true} if {@code food added}, otherwise {@code false}
	 */
	public boolean addFood(FoodBean food1);

	/**
	 * This method is used to do display food menu
	 * 
	 * @param Nothing
	 * @return list<FoodBean>
	 */
	public List<FoodBean> getFoodMenu();
}
