package com.capgemini.hotelmanagementsystem.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelmanagementsystem.bean.FoodBean;
import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.FoodAlredyExistException;
import com.capgemini.hotelmanagementsystem.exception.FoodNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.RoomNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;
import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.repository.FoodRepository;
import com.capgemini.hotelmanagementsystem.repository.RequestRepository;
import com.capgemini.hotelmanagementsystem.repository.RoomRepository;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is FoodOrderDAOImplementation class and implements FoodOrderDAO
 * 
 * @author Manasi Sutar
 */
public class FoodOrderDAOImplementation implements FoodOrderDAO {

	InputValidation inputValidation = Factory.getInputValidationInstance();
	static List<FoodOrderBean> foodOrderList = RequestRepository.getFoodOrderRepositoryInstance().foodOrderDetails();
	static List<FoodBean> foodList = new FoodRepository().foodDetails();
	static List<RoomBean> roomList = new RoomRepository().roomDetails();

	/**
	 * This method is used to order food
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception FoodAlredyExistException
	 * @param foodOrder1 {@code Object}
	 * @return {@code true} if {@code food ordered successfully} , otherwise
	 *         {@code false}
	 */
	@SuppressWarnings("resource")
	public boolean addFoodOrder(FoodOrderBean foodOrder1) {

		final Logger log = Logger.getLogger(FoodOrderDAOImplementation.class);
		Scanner scanner = new Scanner(System.in);
		
		FoodOrderBean foodOrder = Factory.getFoodOrderBeanInstance();
		log.info("***********************Order Food Here***********************\n");
		Factory.getFoodDAOImplementationInstance().getFoodMenu();
		log.info("Please enter your name (Name must contain firstname and lastname)\n");
		String name = scanner.nextLine();
		while (!inputValidation.nameValidation(name)) {
			log.error("Please enter valid  name (Name must contain firstname and lastname)\n");
			name = scanner.nextLine();
		}

		log.info("Please enter room number (Room Number must 3 digit)\n");
		String roomNumber1 = scanner.nextLine();
		while (!inputValidation.roomNumberValidation(roomNumber1)) {
			log.error("Please enter valid  room number (Room Number must 3 digit)\n");
			roomNumber1 = scanner.nextLine();
		}
		int roomNumber = Integer.parseInt(roomNumber1);

		int flag = 0;
		for (RoomBean room : roomList) {
			if (room.getRoomNumber() == roomNumber) {
				flag++;
			}
		}
		if (flag == 0) {
			throw new RoomNotFoundException();
		}

		log.info("Please select food \n");
		String foodchoice = scanner.nextLine();
		while (!inputValidation.foodValidation(foodchoice)) {
			log.error("Please enter only digits \n");
			foodchoice = scanner.nextLine();
		}
		int foodChoice1 = Integer.parseInt(foodchoice);
		int flag1 = 0;
		for (FoodBean food : foodList) {
			if (food.getSrNo() == foodChoice1) {
				flag1++;
			}
		}
		if (flag1 == 0) {
			throw new FoodNotFoundException();
		}

		log.info("Please enter quantity (You can ordered maximum 5 food)\n");
		String quantity1 = scanner.nextLine();
		while (!inputValidation.quantityValidation(quantity1)) {
			log.error("You can ordered maximum 5 food\n");
			quantity1 = scanner.nextLine();
		}
		int quantity = Integer.parseInt(quantity1);
		foodOrder.setQuantity(quantity);
		foodOrder.setName(name);
		foodOrder.setRoomNumber(roomNumber);

		ArrayList<FoodOrderBean> foodOrderList1 = new ArrayList<FoodOrderBean>();
		foodOrderList1.add(foodOrder);
		foodOrderList.addAll(foodOrderList1);
		if (foodOrderList1.isEmpty()) {
			log.error("Food Ordered Failed\n");
			log.error("Please try again...\n");
			return false;
		} else {
			log.info("Food Ordered Successfully... \n");
			return true;
		}

	}

	/**
	 * This method is used display food order list
	 * 
	 * @param Nothing
	 * @return list<FoodOrderBean>
	 */
	public List<FoodOrderBean> getFoodOrderList() {

		final Logger log = Logger.getLogger(FoodOrderDAOImplementation.class);
		log.info("***********************Food Order List***********************\n");
		for (int i = 0; i < foodOrderList.size(); i++) {
			log.info(foodOrderList.get(i) + "\n");
		}
		return foodOrderList;
	}
}
