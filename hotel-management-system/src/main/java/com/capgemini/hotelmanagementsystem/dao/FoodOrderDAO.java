package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.exception.FoodAlredyExistException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;

/**
 * This is FoodOrderDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface FoodOrderDAO {
	/**
	 * This method is used to order food
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception FoodAlredyExistException
	 * @param foodOrder1 {@code Object}
	 * @return {@code true} if {@code food ordered successfully} , otherwise
	 *         {@code false}
	 */
	public boolean addFoodOrder(FoodOrderBean foodOrder1);

	/**
	 * This method is used to display food order list
	 * 
	 * @param Nothing
	 * @return list<FoodOrderBean>
	 */
	public List<FoodOrderBean> getFoodOrderList();
}
