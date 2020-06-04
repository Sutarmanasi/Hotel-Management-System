package com.capgemini.hotelmanagementsystem.validation;

/**
 * This is InputValidation interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface InputValidation {
	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateHotelManagement(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateAdminOperation(String choice);

	/**
	 * This method is used to validate date
	 * 
	 * @param date {@code String}
	 * @return {@code true} if {@code date matches}, otherwise {@code false}
	 */
	public boolean dateValidation(String date);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateOperateHotelDetails(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateHotelValidate(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateOperateRoomDetails(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateEmployeeOperation(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateEmployee(String choice);

	/**
	 * This method is used to validate name
	 * 
	 * @param name {@code String}
	 * @return {@code true} if {@code name matches}, otherwise {@code false}
	 */
	public boolean nameValidation(String name);

	/**
	 * This method is used to validate email
	 * 
	 * @param email {@code String}
	 * @return {@code true} if {@code email matches}, otherwise {@code false}
	 */
	public boolean emailValidation(String email);

	/**
	 * This method is used to validate contactNumber
	 * 
	 * @param contactNumber {@code String}
	 * @return {@code true} if {@code contactNumber matches}, otherwise
	 *         {@code false}
	 */
	public boolean contactNumberValidation(String contactNumber);

	/**
	 * This method is used to validate username
	 * 
	 * @param username {@code String}
	 * @return {@code true} if {@code useername matches}, otherwise {@code false}
	 */
	public boolean usernameValidation(String username);

	/**
	 * This method is used to validate password
	 * 
	 * @param password {@code String}
	 * @return {@code true} if {@code password matches}, otherwise {@code false}
	 */
	public boolean passwordValidation(String password);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateRoomValidate(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateCustomer(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateCustomerOperation(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateEmployeeInformationValidate(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateCustomerDetailsValidate(String choice);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidation(String choice);

	/**
	 * This method is used to validate noOfPerson1
	 * 
	 * @param noOfPerson1 {@code String}
	 * @return {@code true} if {@code noOfPerson1 matches}, otherwise {@code false}
	 */
	public boolean choiceSingleValidation(String noOfPerson1);

	/**
	 * This method is used to validate noOfPerson2
	 * 
	 * @param noOfPerson2 {@code String}
	 * @return {@code true} if {@code noOfPerson2 matches}, otherwise {@code false}
	 */
	public boolean choiceDoubleValidation(String noOfPerson2);

	/**
	 * This method is used to validate salary
	 * 
	 * @param salary {@code String}
	 * @return {@code true} if {@code salary matches}, otherwise {@code false}
	 */
	public boolean salaryValidation(String salary);

	/**
	 * This method is used to validate quantity1
	 * 
	 * @param quantity1 {@code String}
	 * @return {@code true} if {@code quantity1 matches}, otherwise {@code false}
	 */
	public boolean quantityValidation(String quantity1);

	/**
	 * This method is used to validate foodchoice
	 * 
	 * @param foodchoice {@code String}
	 * @return {@code true} if {@code foodchoice matches}, otherwise {@code false}
	 */
	public boolean foodChoiceValidation(String foodchoice);

	/**
	 * This method is used to validate foodType
	 * 
	 * @param foodType {@code String}
	 * @return {@code true} if {@code foodType matches}, otherwise {@code false}
	 */
	public boolean foodTypeValidation(String foodType);

	/**
	 * This method is used to validate roomNumber1
	 * 
	 * @param roomNumber1 {@code String}
	 * @return {@code true} if {@code roomNumber1 matches}, otherwise {@code false}
	 */
	public boolean roomNumberValidation(String roomNumber1);

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean foodValidation(String choice);

	/**
	 * This method is used to validate srNo1
	 * 
	 * @param srNo1 {@code String}
	 * @return {@code true} if {@code srNo1 matches}, otherwise {@code false}
	 */
	public boolean srNoValidation(String srNo1);
	

	/**
	 * This method is used to validate string
	 * 
	 * @param srNo1 {@code String}
	 * @return {@code true} if {@code string matches}, otherwise {@code false}
	 */
	public boolean stringValidation(String choice);
}
