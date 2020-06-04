package com.capgemini.hotelmanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is InputValidationImplementation class and implements InputValidation
 * 
 * @author Manasi Sutar
 */
public class InputValidationImplementation implements InputValidation {

	Pattern pat = null;
	Matcher mat = null;

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateHotelManagement(String choice) {
		pat = Pattern.compile("[1-4]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateAdminOperation(String choice) {
		pat = Pattern.compile("[1-9]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean dateValidation(String date) {
		if (date.matches("^(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateOperateHotelDetails(String choice) {
		pat = Pattern.compile("[1-4]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateHotelValidate(String choice) {
		pat = Pattern.compile("[1-5]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateOperateRoomDetails(String choice) {
		pat = Pattern.compile("[1-5]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateEmployeeOperation(String choice) {
		pat = Pattern.compile("[1-7]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate name
	 * 
	 * @param name {@code String}
	 * @return {@code true} if {@code name matches}, otherwise {@code false}
	 */
	public boolean nameValidation(String name) {
		pat = Pattern.compile("[A-z][a-z]*+\\s[A-z][a-z]*+");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;

	}

	/**
	 * This method is used to validate email
	 * 
	 * @param email {@code String}
	 * @return {@code true} if {@code email matches}, otherwise {@code false}
	 */
	public boolean emailValidation(String email) {
		pat = Pattern.compile("^[\\w.+\\-]+@gmail\\.com$");
		mat = pat.matcher(email);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate contactNumber
	 * 
	 * @param contactNumber {@code String}
	 * @return {@code true} if {@code contactNumber matches}, otherwise
	 *         {@code false}
	 */
	public boolean contactNumberValidation(String contactNumber) {
		if (contactNumber.matches("[7-9][0-9]{9}")) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateEmployee(String choice) {
		pat = Pattern.compile("[1-3]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate username
	 * 
	 * @param username {@code String}
	 * @return {@code true} if {@code useername matches}, otherwise {@code false}
	 */
	public boolean usernameValidation(String username) {
		pat = Pattern.compile("^[a-z0-9_-]{3,15}$");
		mat = pat.matcher(username);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate password
	 * 
	 * @param password {@code String}
	 * @return {@code true} if {@code password matches}, otherwise {@code false}
	 */
	public boolean passwordValidation(String password) {
		pat = Pattern.compile("^(?=.*[0-9]).{8,15}$");
		mat = pat.matcher(password);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateRoomValidate(String choice) {
		pat = Pattern.compile("[1-4]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateCustomer(String choice) {
		pat = Pattern.compile("[1-3]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidateCustomerOperation(String choice) {
		pat = Pattern.compile("[1-5]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateEmployeeInformationValidate(String choice) {
		pat = Pattern.compile("[1-9]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceUpdateCustomerDetailsValidate(String choice) {
		pat = Pattern.compile("[1-4]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean choiceValidation(String choice) {
		pat = Pattern.compile("[1-2]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate noOfPerson1
	 * 
	 * @param noOfPerson1 {@code String}
	 * @return {@code true} if {@code noOfPerson1 matches}, otherwise {@code false}
	 */
	public boolean choiceSingleValidation(String noOfPerson1) {
		pat = Pattern.compile("[1-2]");
		mat = pat.matcher(noOfPerson1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate noOfPerson2
	 * 
	 * @param noOfPerson2 {@code String}
	 * @return {@code true} if {@code noOfPerson2 matches}, otherwise {@code false}
	 */
	public boolean choiceDoubleValidation(String noOfPerson2) {
		pat = Pattern.compile("[1-4]");
		mat = pat.matcher(noOfPerson2);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate salary
	 * 
	 * @param salary {@code String}
	 * @return {@code true} if {@code salary matches}, otherwise {@code false}
	 */
	public boolean salaryValidation(String salary) {
		pat = Pattern.compile("\\d{4,5}");
		mat = pat.matcher(salary);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate quantity1
	 * 
	 * @param quantity1 {@code String}
	 * @return {@code true} if {@code quantity1 matches}, otherwise {@code false}
	 */
	public boolean quantityValidation(String quantity1) {
		pat = Pattern.compile("[1-5]");
		mat = pat.matcher(quantity1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate foodchoice
	 * 
	 * @param foodchoice {@code String}
	 * @return {@code true} if {@code foodchoice matches}, otherwise {@code false}
	 */
	public boolean foodChoiceValidation(String foodchoice) {
		pat = Pattern.compile("[1-10]");
		mat = pat.matcher(foodchoice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate foodType
	 * 
	 * @param foodType {@code String}
	 * @return {@code true} if {@code foodType matches}, otherwise {@code false}
	 */
	public boolean foodTypeValidation(String foodType) {
		pat = Pattern.compile("[1-4]");
		mat = pat.matcher(foodType);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean roomNumberValidation(String roomNumber1) {
		pat = Pattern.compile("\\d{3}");
		mat = pat.matcher(roomNumber1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate choice
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if {@code choice matches}, otherwise {@code false}
	 */
	public boolean foodValidation(String choice) {
		pat = Pattern.compile("\\d{2}");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate srNo1
	 * 
	 * @param srNo1 {@code String}
	 * @return {@code true} if {@code srNo1 matches}, otherwise {@code false}
	 */
	public boolean srNoValidation(String srNo1) {
		if (srNo1.matches("\\d{2}")) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to validate string
	 * 
	 * @param srNo1 {@code String}
	 * @return {@code true} if {@code string matches}, otherwise {@code false}
	 */
	@Override
	public boolean stringValidation(String choice) {
		pat = Pattern.compile("([A-Za-z].*)$");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
}
