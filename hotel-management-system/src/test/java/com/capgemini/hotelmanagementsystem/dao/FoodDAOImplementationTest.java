package com.capgemini.hotelmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.bean.FoodBean;
import com.capgemini.hotelmanagementsystem.dao.FoodDAO;
import com.capgemini.hotelmanagementsystem.dao.FoodDAOImplementation;
import com.capgemini.hotelmanagementsystem.exception.FoodAlredyExistException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is FoodDAOImplementationTest class and here we write testcases
 * 
 * @author Manasi Sutar
 */
class FoodDAOImplementationTest {

	static final Logger log = Logger.getLogger(FoodDAOImplementation.class);

	/**
	 * This method is used to test add food
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception FoodAlredyExistException
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Add Food")
	void testAddFood() {
		log.info("****************Test Case for Add Food****************\n");
		FoodDAO foodDAO = Factory.getFoodDAOImplementationInstance();
		FoodBean food = Factory.getFoodBeanInstance();
		try {
			assertEquals(true, foodDAO.addFood(food));
		} catch (SrNoAlredyExistException e) {
			log.info(e.getMessage());
		} catch (FoodAlredyExistException e) {
			log.info(e.getMessage());
		}

	}

	/**
	 * This method is used to test get food menu
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Food Menu")
	void testGetFoodMenu() {
		log.info("****************Test Case for Get Food Menu****************\n");
		FoodDAO foodDAO = Factory.getFoodDAOImplementationInstance();
		assertNotNull(foodDAO.getFoodMenu());
	}
}
