package com.capgemini.hotelmanagementsystem.bean;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This is BookingBean class and here we declared variables and written getter
 * setter methods and it implements Serializable
 * 
 * @author Manasi Sutar
 */

@SuppressWarnings("serial")
public class BookingBean implements Serializable {

	private LocalDate bookingDate;
	private String hotelName;
	private String name;
	private String address;
	private String email;
	private long contactNumber;
	private int noOfPerson;
	private String roomType;
	private String idProof;
	private String paymentMethod;

	/**
	 * This method is used to get bookingDate
	 * 
	 * @param Nothing
	 * @return bookingDate {@code LocalDate}
	 */

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	/**
	 * This method is used to set bookingDate
	 * 
	 * @param bookingDate {@code LocalDate}
	 * @return Nothing
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * This method is used to get hotelName
	 * 
	 * @param Nothing
	 * @return hotelName {@code String}
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * This method is used to set hotelName
	 * 
	 * @param hotelName {@code String}
	 * @return Nothing
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * This method is used to get name
	 * 
	 * @param Nothing
	 * @return name {@code String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is used to set name
	 * 
	 * @param name {@code String}
	 * @return Nothing
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is used to get address
	 * 
	 * @param Nothing
	 * @return address {@code String}
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method is used to set address
	 * 
	 * @param address {@code String}
	 * @return Nothing
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method is used to get email
	 * 
	 * @param Nothing
	 * @return email {@code String}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method is used to set email
	 * 
	 * @param email {@code String}
	 * @return Nothing
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method is used to get contactNumber
	 * 
	 * @param Nothing
	 * @return contactNumber {@code long}
	 */
	public long getContactNumber() {
		return contactNumber;
	}

	/**
	 * This method is used to set contactNumber
	 * 
	 * @param contactNumber {@code long}
	 * @return Nothing
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * This method is used to get noOfPerson
	 * 
	 * @param Nothing
	 * @return noOfPerson {@code int}
	 */
	public int getNoOfPerson() {
		return noOfPerson;
	}

	/**
	 * This method is used to set noOfPerson
	 * 
	 * @param noOfPerson {@code int}
	 * @return Nothing
	 */
	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	/**
	 * This method is used to get roomType
	 * 
	 * @param Nothing
	 * @return roomType {@code String}
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * This method is used to set roomType
	 * 
	 * @param roomType {@code String}
	 * @return Nothing
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * This method is used to get idProof
	 * 
	 * @param Nothing
	 * @return idProof {@code String}
	 */
	public String getIdProof() {
		return idProof;
	}

	/**
	 * This method is used to set idProof
	 * 
	 * @param idProof {@code String}
	 * @return Nothing
	 */
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	/**
	 * This method is used to get paymentMethod
	 * 
	 * @param Nothing
	 * @return paymentMethod {@code String}
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * This method is used to set paymentMethod
	 * 
	 * @param paymentMethod {@code String}
	 * @return Nothing
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * This method is used to display booking details
	 * 
	 * @param Nothing
	 * @return String
	 */
	@Override
	public String toString() {
		return "Booking Date = " + bookingDate + "\nHotel Name = " + hotelName + "\nName = " + name + "\nAddress = "
				+ address + "\nEmail = " + email + "\nContact Number = " + contactNumber + "\nRoom Type = " + roomType
				+ "\nNumber of persons = " + noOfPerson + "\nId proof = " + idProof + "\nPayment Method = "
				+ paymentMethod + "\n";
	}
}
