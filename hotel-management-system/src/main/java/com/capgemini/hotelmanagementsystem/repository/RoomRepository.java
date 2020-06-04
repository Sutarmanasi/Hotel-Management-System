package com.capgemini.hotelmanagementsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.factory.Factory;

/**
 * This is RoomRepository class and here we dummy data
 * 
 * @author Manasi Sutar
 */
public class RoomRepository {

	/**
	 * This method is used to set roomDetails
	 * 
	 * @param Nothing
	 * @return list<RoomBean>
	 */
	public List<RoomBean> roomDetails() {

		List<RoomBean> roomList = new ArrayList<RoomBean>();

		RoomBean room = Factory.getRoomBeanInstance();

		room.setRoomNumber(101);
		room.setRoomType("Single");
		room.setAcOrNonAc("AC");

		RoomBean room1 = Factory.getRoomBeanInstance();

		room1.setRoomNumber(102);
		room1.setRoomType("Double");
		room1.setAcOrNonAc("AC");

		RoomBean room2 = Factory.getRoomBeanInstance();

		room2.setRoomNumber(103);
		room2.setRoomType("Single");
		room2.setAcOrNonAc("Non AC");

		RoomBean room3 = Factory.getRoomBeanInstance();

		room3.setRoomNumber(104);
		room3.setRoomType("Double");
		room3.setAcOrNonAc("Non AC");

		roomList.add(room);
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);

		return roomList;
	}
}
