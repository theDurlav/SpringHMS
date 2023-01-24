package com.core.hms.rajhans.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.hms.rajhans.entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Repository
public class OrderDaoImpl implements OrderDao {
	EntityManager entityManager;
	public OrderDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void addOrder(Order order) {
			entityManager.persist(order);
	}

	@Override
	public List<Order> listOrder() {
		Query query = entityManager.createQuery("from Order");
		List<Order> orders;
		orders = query.getResultList();
		return orders;
	}

	@Override
	public void deleteOrder(int orderId) {
		Order order = entityManager.find(Order.class, orderId);
		entityManager.remove(order);

	}

	@Override
	public Order getOrder(int theId) {
		return entityManager.find(Order.class, theId);
	}

}
