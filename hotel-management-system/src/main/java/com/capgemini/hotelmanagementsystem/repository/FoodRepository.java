package com.capgemini.hotelmanagementsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.FoodBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is FoodRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */
public class FoodRepository {

	/**
	 * This method is used to set foodDetails
	 * 
	 * @param Nothing
	 * @return list<FoodBean>
	 */
	public List<FoodBean> foodDetails() {

		List<FoodBean> foodList = new ArrayList<FoodBean>();

		FoodBean food = Factory.getFoodBeanInstance();
		food.setSrNo(1);
		food.setFoodType("INDIAN BREADS");
		food.setFoodName("Roti");

		FoodBean food1 = Factory.getFoodBeanInstance();
		food1.setSrNo(2);
		food1.setFoodType("INDIAN BREADS");
		food1.setFoodName("Paratha");

		FoodBean food2 = Factory.getFoodBeanInstance();
		food2.setSrNo(3);
		food2.setFoodType("INDIAN BREADS");
		food2.setFoodName("Naan");

		FoodBean food3 = Factory.getFoodBeanInstance();
		food3.setSrNo(4);
		food3.setFoodType("RICE");
		food3.setFoodName("Steam Rice");

		FoodBean food4 = Factory.getFoodBeanInstance();
		food4.setSrNo(5);
		food4.setFoodType("RICE");
		food4.setFoodName("Jeera Rice");

		FoodBean food5 = Factory.getFoodBeanInstance();
		food5.setSrNo(6);
		food5.setFoodType("STARTERS");
		food5.setFoodName("Soup");

		FoodBean food6 = Factory.getFoodBeanInstance();
		food6.setSrNo(7);
		food6.setFoodType("STARTERS");
		food6.setFoodName("French Fries");

		FoodBean food7 = Factory.getFoodBeanInstance();
		food7.setSrNo(8);
		food7.setFoodType("STARTERS");
		food7.setFoodName("Manchurian");

		FoodBean food8 = Factory.getFoodBeanInstance();
		food8.setSrNo(9);
		food8.setFoodType("DESSERTS");
		food8.setFoodName("Ice-Cream");

		FoodBean food9 = Factory.getFoodBeanInstance();
		food9.setSrNo(10);
		food9.setFoodType("DESSERTS");
		food9.setFoodName("Gulab Jamoon");

		foodList.add(food);
		foodList.add(food1);
		foodList.add(food2);
		foodList.add(food3);
		foodList.add(food4);
		foodList.add(food5);
		foodList.add(food6);
		foodList.add(food7);
		foodList.add(food8);
		foodList.add(food9);

		return foodList;
	}
}
