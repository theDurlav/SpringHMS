package com.core.hms.rajhans.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.hms.rajhans.entity.Customer;
import com.core.hms.rajhans.entity.Order;
import com.core.hms.rajhans.entity.Room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	EntityManager entityManager;
	public CustomerDaoImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
	}

	@Override
	public void addCustomer(Customer customer) {
		if(customer.getId()>0) {
			entityManager.merge(customer);
		}
		else {
			entityManager.persist(customer);
		}
	}

	@Override
	public void deleteCustomer(int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		entityManager.remove(customer);
	}

	@Override
	public Customer findCustomer(int customerId) {
		Customer customer =entityManager.find(Customer.class, customerId);
		return customer;
	}

	@Override
	public List<Customer> listCustomer() {
		List<Customer> customers;
		Query theQuery = entityManager.createQuery("from Customer");
		customers =theQuery.getResultList();
		return customers;
	}

	@Override
	public void addOrder(int customerId, int orderId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		Order order = entityManager.find(Order.class, orderId);
		customer.addOrder(order);
		entityManager.merge(customer);
	}

	@Override
	public void addRoom(int customerId, int roomId) { 
		Customer customer = entityManager.find(Customer.class, customerId);
		customer.setRoom(entityManager.find(Room.class, roomId));
		entityManager.merge(customer);
	}

}
