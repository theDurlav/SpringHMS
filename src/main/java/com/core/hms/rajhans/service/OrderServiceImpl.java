package com.core.hms.rajhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.core.hms.rajhans.dao.OrderDao;
import com.core.hms.rajhans.entity.Order;

import jakarta.transaction.Transactional;
@Service
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;
	
	public OrderServiceImpl(OrderDao  theOrderDao) {
		orderDao = theOrderDao;
	}
	@Transactional
	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);

	}
	@Transactional
	@Override
	public List<Order> listOrder() {
		return orderDao.listOrder();
	}
	@Transactional
	@Override
	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
	}
	@Transactional
	@Override
	public Order getOrder(int theId) {
		return orderDao.getOrder(theId);
	}

}
