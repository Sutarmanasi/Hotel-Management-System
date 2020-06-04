package com.capgemini.hotelmanagementsystem.repository;

/**
 * This is RequestRepository class and here we create object of other repository
 * classes
 * 
 * @author Manasi Sutar
 */
public class RequestRepository {
	/**
	 * This method is used to create object of BookingRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static BookingRepository getBookingRepositoryInstance() {
		return new BookingRepository();
	}

	/**
	 * This method is used to create object of HotelRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static HotelRepository getHotelRepositoryInstance() {
		return new HotelRepository();
	}

	/**
	 * This method is used to create object of RoomRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static RoomRepository getRoomRepositoryInstance() {
		return new RoomRepository();
	}

	/**
	 * This method is used to create object of EmployeeRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static EmployeeRepository getEmployeeRepositoryInstance() {
		return new EmployeeRepository();
	}

	/**
	 * This method is used to create object of CustomerRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static CustomerRepository getCustomerRepositoryInstance() {
		return new CustomerRepository();
	}

	/**
	 * This method is used to create object of FoodRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static FoodRepository getFoodRepositoryInstance() {
		return new FoodRepository();
	}

	/**
	 * This method is used to create object of FoodOrderRepository
	 * 
	 * @param Nothing
	 * @return object
	 */
	public static FoodOrderRepository getFoodOrderRepositoryInstance() {
		return new FoodOrderRepository();
	}
}
