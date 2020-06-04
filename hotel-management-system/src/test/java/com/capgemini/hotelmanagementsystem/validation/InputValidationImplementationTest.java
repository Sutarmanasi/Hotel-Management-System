package com.capgemini.hotelmanagementsystem.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelmanagementsystem.factory.Factory;
import com.capgemini.hotelmanagementsystem.validation.InputValidation;

/**
 * This is InputValidationImplementationTest class
 * 
 * @author Manasi Sutar
 */
class InputValidationImplementationTest {

	static final Logger log = Logger.getLogger(InputValidationImplementationTest.class);
	InputValidation inputValidation = Factory.getInputValidationInstance();

	/**
	 * This method is used to test validUsername
	 * 
	 * @param Nothing
	 * @return Nothing
	 */

	@Test
	@DisplayName("Valid Username")
	public void usernameValidationTest() {
		assertEquals(true, inputValidation.usernameValidation("manasi"));
	}

	/**
	 * This method is used to test invalidUsername
	 * 
	 * @param Nothing
	 * @return Nothing
	 */

	@Test
	@DisplayName("Invalid Username")
	public void usernameValidationTest1() {
		assertEquals(false, inputValidation.usernameValidation("ma"));
	}

	/**
	 * This method is used to test validName
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Valid Name")
	public void nameValidationTest() {
		assertEquals(true, inputValidation.nameValidation("manasi sutar"));
	}

	/**
	 * This method is used to test invalidName
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Invalid Name")
	public void nameValidationTest1() {
		assertEquals(false, inputValidation.nameValidation("manasi"));
	}

	/**
	 * This method is used to test validEmail
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Valid Email")
	public void emailValidationTest() {
		assertEquals(true, inputValidation.emailValidation("manasi@gmail.com"));
	}

	/**
	 * This method is used to test invalidEmail
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Invalid Email")
	public void emailValidationTest1() {
		assertEquals(false, inputValidation.emailValidation("manasi@"));
	}

	/**
	 * This method is used to test valid contactNumber
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Valid Contact Number")
	public void contactNumberValidationTest() {
		assertEquals(true, inputValidation.contactNumberValidation("7083788695"));
	}

	/**
	 * This method is used to test invalid contactNumber
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Invalid Contact Number")
	public void contactNumberValidationTest1() {
		assertEquals(false, inputValidation.contactNumberValidation("123654"));
	}

	/**
	 * This method is used to test validDate
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Valid Date")
	public void dateValidationTest() {
		assertEquals(true, inputValidation.dateValidation("2020-05-14"));
	}

	/**
	 * This method is used to test invalidDate
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	@Test
	@DisplayName("Invalid Date")
	public void dateValidationTest1() {
		assertEquals(false, inputValidation.dateValidation("14-05-2020"));
	}
}
