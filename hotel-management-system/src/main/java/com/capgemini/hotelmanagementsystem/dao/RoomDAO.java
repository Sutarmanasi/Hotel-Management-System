package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;

/**
 * This is RoomDAO interface and here we declared methods
 * 
 * @author Manasi Sutar
 */
public interface RoomDAO {
	/**
	 * This method is used to add room
	 * 
	 * @exception RoomAlreadyExistException
	 * @param room1 {@code Object}
	 * @return {@code true} if {@code room added successfully} , otherwise
	 *         {@code false}
	 */
	public boolean addRoom(RoomBean room1);

	/**
	 * This method is used to delete room
	 * 
	 * @exception RoomNotFoundException
	 * @param roomNumber1 {@code int}
	 * @return {@code true} if {@code room deleted successfully} , otherwise
	 *         {@code false}
	 */
	public boolean deleteRoom(int roomNumber);
	/**
	 * This method is used to update room
	 * 
	 * @exception RoomNotFoundException
	 * @param roomBean {@code object}
	 * @return {@code true} if {@code room updated successfully} , otherwise
	 *         {@code false}
	 */
	public boolean updateRoom(RoomBean roomBean);
	/**
	 * This method is used to display rooms
	 * 
	 * @param Nothing
	 * @return list<RoomBean>
	 */
	public List<RoomBean> getAllRoomDetails();
}
