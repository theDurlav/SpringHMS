package com.core.hms.rajhans.service;

import java.util.List;

import com.core.hms.rajhans.entity.Room;

public interface RoomService {
	public void addRoom(Room room);
	public List<Room> listRoom();
	public void deleteRoom(int roomId);
	public Room getRoom(int theId);
}
