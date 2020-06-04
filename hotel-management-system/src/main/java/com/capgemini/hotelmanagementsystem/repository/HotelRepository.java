package com.capgemini.hotelmanagementsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is HotelRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */
public class HotelRepository {

	/**
	 * This method is used to set hotelDetails
	 * 
	 * @param Nothing
	 * @return list<HotelBean>
	 */
	public List<HotelBean> hotelDetails() {

		List<HotelBean> hotelList = new ArrayList<HotelBean>();

		HotelBean hotel = Factory.getHotelBeanInstance();

		hotel.setSrNo(1);
		hotel.setHotelName("TajHotel");
		hotel.setHotelAddress("Mumbai");
		hotel.setNoOfRooms(20);
		hotel.setContactNumber(9028802697l);

		HotelBean hotel1 = Factory.getHotelBeanInstance();

		hotel1.setSrNo(2);
		hotel1.setHotelName("DypHotel");
		hotel1.setHotelAddress("Kolhapur");
		hotel1.setNoOfRooms(10);
		hotel1.setContactNumber(8805939067l);

		hotelList.add(hotel);
		hotelList.add(hotel1);
		return hotelList;
	}
}
