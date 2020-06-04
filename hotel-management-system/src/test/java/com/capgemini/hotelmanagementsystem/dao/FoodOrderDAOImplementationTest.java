package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.dao.FoodOrderDAO;
import com.capgemini.hotelmanagementsystem.exception.RoomNotFoundException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is FoodOrderDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class FoodOrderDAOImplementationTest {

	static final Logger log = Logger.getLogger(FoodOrderDAOImplementationTest.class);

	/**
	 * This method is used to test add food order
	 * 
	 * @exception RoomNotFoundException
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Food Order")
	void testFoodOrder() {
		log.info("****************Test Case for Food Order****************\n");
		FoodOrderDAO foodOrderDAO = Factory.getFoodOrderDAOImplementationInstance();
		FoodOrderBean foodOrder = Factory.getFoodOrderBeanInstance();

		try {
			assertEquals(true, foodOrderDAO.addFoodOrder(foodOrder));
		} catch (RoomNotFoundException e) {
			log.info(e.getMessage());
		}

	}
}
