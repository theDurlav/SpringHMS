package com.core.hms.rajhans.dao;

import java.util.List;

import com.core.hms.rajhans.entity.Order;

public interface OrderDao {
		public void addOrder(Order order);
		public List<Order> listOrder();
		public void deleteOrder(int orderId);
		public Order getOrder(int theId); 
}
