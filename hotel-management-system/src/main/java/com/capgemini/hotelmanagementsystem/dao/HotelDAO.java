package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.HotelNotFoundException;
import com.capgemini.hotelmanagementsystem.exception.SrNoAlredyExistException;

/**
 * This is HotelDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface HotelDAO {
	/**
	 * This method is used to add hotel
	 * 
	 * @exception SrNoAlredyExistException
	 * @exception HotelAlreadyExistException
	 * @param hotel1 {@code Object}
	 * @return {@code true} if {@code hotel added successfully} , otherwise
	 *         {@code false}
	 */
	public boolean addHotel(HotelBean hotel1);

	/**
	 * This method is used to delete hotel
	 * 
	 * @exception HotelNotFoundException
	 * @param hotelName {@code String}
	 * @return {@code true} if {@code hotel deleted successfully} , otherwise
	 *         {@code false}
	 */
	public boolean deleteHotel(String hotelName);

	/**
	 * This method is used to update hotel
	 * 
	 * @exception HotelNotFoundException
	 * @param hotelBeanF {@code object}
	 * @return {@code true} if {@code hotel updated successfully} , otherwise
	 *         {@code false}
	 */
	public boolean updateHotel(HotelBean hotelBean);

	/**
	 * This method is used to display hotel list
	 * 
	 * @param Nothing
	 * @return list<HotelBean>
	 */
	public List<HotelBean> getAllHotelDetails();

}
