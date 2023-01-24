package com.core.hms.rajhans.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.core.hms.rajhans.dao.RoomDao;
import com.core.hms.rajhans.entity.Room;
@Service
public class RoomServiceImpl implements RoomService {
	private RoomDao roomDao;
	public RoomServiceImpl(RoomDao theRoomDao) {
		roomDao = theRoomDao;
	}
	@Transactional
	@Override
	public void addRoom(Room room) {
		roomDao.addRoom(room);
	}
	@Transactional
	@Override
	public List<Room> listRoom() {
		return roomDao.listRoom();
	}
	@Transactional
	@Override
	public void deleteRoom(int roomId) {
		roomDao.deleteRoom(roomId);
	}
	@Transactional
	@Override
	public Room getRoom(int theId) {
		return roomDao.getRoom(theId);
	}

}
