package com.capgemini.hotelmanagementsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is FoodOrderRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */
public class FoodOrderRepository {

	/**
	 * This method is used to set foodOrderDetails
	 * 
	 * @param Nothing
	 * @return list<FoodOrderBean>
	 */
	public List<FoodOrderBean> foodOrderDetails() {

		List<FoodOrderBean> foodOrderList = new ArrayList<FoodOrderBean>();

		FoodOrderBean foodOrder = Factory.getFoodOrderBeanInstance();
		foodOrder.setName("Manasi Sutar");
		foodOrder.setRoomNumber(101);
		foodOrder.setFoodName("Jeera Rice");
		foodOrder.setQuantity(1);

		FoodOrderBean foodOrder1 = Factory.getFoodOrderBeanInstance();
		foodOrder1.setName("Gayatri Sutar");
		foodOrder1.setRoomNumber(103);
		foodOrder1.setFoodName("Manchurian");
		foodOrder1.setQuantity(2);

		foodOrderList.add(foodOrder);
		foodOrderList.add(foodOrder1);

		return foodOrderList;
	}
}
