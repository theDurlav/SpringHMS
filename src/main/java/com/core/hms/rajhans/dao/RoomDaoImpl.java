package com.core.hms.rajhans.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.hms.rajhans.entity.Room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Repository
public class RoomDaoImpl implements RoomDao {
	EntityManager entityManager;
	public RoomDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void addRoom(Room room) {
		if(room.getId()>0)
			entityManager.merge(room);
		else
			entityManager.persist(room);
	}

	@Override
	public List<Room> listRoom() {
		Query query = entityManager.createQuery("from Room");
		List<Room> rooms;
		rooms = query.getResultList();
		return rooms;
	}

	@Override
	public void deleteRoom(int roomId) {
		Room room = entityManager.find(Room.class, roomId);
		entityManager.remove(room);

	}

	@Override
	public Room getRoom(int theId) {
		Room room = entityManager.find(Room.class, theId);
		return room;
	}

}
