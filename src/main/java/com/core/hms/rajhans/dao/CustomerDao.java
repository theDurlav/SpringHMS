package com.core.hms.rajhans.dao;

import java.util.List;

import com.core.hms.rajhans.entity.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public Customer findCustomer(int customerId);
	public List<Customer> listCustomer();
	public void addOrder(int customerId,int orderId);
	public void addRoom(int customerId,int roomId);
}
