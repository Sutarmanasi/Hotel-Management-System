package com.capgemini.hotelmanagementsystem.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.FoodBean;
import com.capgemini.hotelmanagementsystem.exception.FoodAlredyExistException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is FoodDAOImplementation class and implements FoodDAO
 * 
 * @author Manasi Sutar
 */
public class FoodDAOImplementation implements FoodDAO {

	InputValidation inputValidation = Factory.getInputValidationInstance();
	static List<FoodBean> foodList = RequestRepository.getFoodRepositoryInstance().foodDetails();
	

	/**
	 * This method is used to do display food menu
	 * 
	 * @param Nothing
	 * @return list<FoodBean>
	 */
	public List<FoodBean> getFoodMenu() {

		final Logger log = Logger.getLogger(FoodDAOImplementation.class);
		log.info("***********************Food Menu***********************\n");
		for (int i = 0; i < foodList.size(); i++) {
			log.info(foodList.get(i) + "\n");
		}
		return foodList;
	}

	/**
	 * This method is used to add food
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception FoodAlredyExistException
	 * @param food {@code Object}
	 * @return {@code true} if {@code food added}, otherwise {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean addFood(FoodBean food1) {

		final Logger log = Logger.getLogger(FoodDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		
		FoodBean food = Factory.getFoodBeanInstance();

		log.info("***********************Add Food Menu***********************\n");
		log.info("Please enter food type (INDIAN BREADS/RICE/STARTERS/DESERTS)\n");
		log.info("1. INDIAN BREADS \n2. RICE \n3. STARTERS \n4. DESERTS\n");
		String foodType = scanner.nextLine();
		while (!inputValidation.foodTypeValidation(foodType)) {
			log.error("Please enter from 1-4\n");
			foodType = scanner.nextLine();
		}
		int foodType1 = Integer.parseInt(foodType);
		int flag = 0;
		switch (foodType1) {
		case 1:
			food.setFoodType("INDIAN BREADS");
			log.info("Please enter SrNo (2 digit)\n");
			String srNo1 = scanner.nextLine();
			while (!inputValidation.srNoValidation(srNo1)) {
				log.error("Please enter only 2 digits\n");
				srNo1 = scanner.nextLine();
			}
			int srNo = Integer.parseInt(srNo1);
			for (FoodBean food2 : foodList) {
				if (food2.getSrNo() == srNo) {
					flag = 1;
				}
			}
			if (flag == 1) {
				throw new SrNoAlredyExistException();
			}
			food.setSrNo(srNo);
			log.info("Please enter food name\n");
			String foodName = scanner.nextLine();
			for (FoodBean food2 : foodList) {
				if (food2.getFoodName().equals(foodName)) {
					flag = 2;
				}
			}
			if (flag == 2) {
				throw new FoodAlredyExistException();
			}
			food.setFoodName(foodName);
			break;

		case 2:
			food.setFoodType("RICE");
			log.info("Please enter SrNo (2 digit)\n");
			String srNo2 = scanner.nextLine();
			while (!inputValidation.srNoValidation(srNo2)) {
				log.error("Please enter only 2 digits\n");
				srNo2 = scanner.nextLine();
			}
			int srNo3 = Integer.parseInt(srNo2);
			for (FoodBean food2 : foodList) {
				if (food2.getSrNo() == srNo3) {
					flag = 3;
				}
			}
			if (flag == 3) {
				throw new SrNoAlredyExistException();
			}
			food.setSrNo(srNo3);
			log.info("Please enter food name\n");
			String foodName1 = scanner.nextLine();
			for (FoodBean food2 : foodList) {
				if (food2.getFoodName().equals(foodName1)) {
					flag = 4;
				}
			}
			if (flag == 4) {
				throw new FoodAlredyExistException();
			}
			food.setFoodName(foodName1);
			break;

		case 3:
			food.setFoodType("STARTERS");
			log.info("Please enter SrNo (2 digit)\n");
			String srNo4 = scanner.nextLine();
			while (!inputValidation.srNoValidation(srNo4)) {
				log.error("Please enter only 2 digits\n");
				srNo4 = scanner.nextLine();
			}
			int srNo5 = Integer.parseInt(srNo4);
			for (FoodBean food2 : foodList) {
				if (food2.getSrNo() == srNo5) {
					flag = 5;
				}
			}
			if (flag == 5) {
				throw new SrNoAlredyExistException();
			}
			food.setSrNo(srNo5);
			log.info("Please enter food name\n");
			String foodName2 = scanner.nextLine();
			for (FoodBean food2 : foodList) {
				if (food2.getFoodName().equals(foodName2)) {
					flag = 6;
				}
			}
			if (flag == 6) {
				throw new FoodAlredyExistException();
			}
			food.setFoodName(foodName2);
			break;

		case 4:
			food.setFoodType("DESERTS");
			log.info("Please enter SrNo (2 digit)\n");
			String srNo6 = scanner.nextLine();
			while (!inputValidation.srNoValidation(srNo6)) {
				log.error("Please enter only 2 digits\n");
				srNo6 = scanner.nextLine();
			}
			int srNo7 = Integer.parseInt(srNo6);
			for (FoodBean food2 : foodList) {
				if (food2.getSrNo() == srNo7) {
					flag = 7;
				}
			}
			if (flag == 7) {
				throw new SrNoAlredyExistException();
			}
			food.setSrNo(srNo7);
			log.info("Please enter food name\n");
			String foodName3 = scanner.nextLine();
			for (FoodBean food2 : foodList) {
				if (food2.getFoodName().equals(foodName3)) {
					flag = 8;
				}
			}
			if (flag == 8) {
				throw new FoodAlredyExistException();
			}
			food.setFoodName(foodName3);
			break;

		default:
			log.info("Please enter valid input\n");
		}

		ArrayList<FoodBean> list = new ArrayList<FoodBean>();
		list.add(food);
		foodList.addAll(list);
		if (list.isEmpty()) {
			log.error("Food not added\n");
			log.error("Please try again....\n");
			return false;
		} else {
			log.info("Food added\n");
			return true;
		}
	}
}
