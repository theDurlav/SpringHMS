package com.core.hms.rajhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.core.hms.rajhans.dao.CustomerDao;
import com.core.hms.rajhans.entity.Customer;

import jakarta.transaction.Transactional;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private  CustomerDao customerDao;
	public CustomerServiceImpl(CustomerDao theCustomerDao) {
		customerDao = theCustomerDao;
	}
	@Transactional
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	@Transactional
	@Override
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}
	@Transactional
	@Override
	public Customer findCustomer(int customerId) {
		return customerDao.findCustomer(customerId);
	}
	@Transactional
	@Override
	public List<Customer> listCustomer() {
		return customerDao.listCustomer();
	}
	@Transactional
	@Override
	public void addOrder(int customerId, int orderId) {
		customerDao.addOrder(customerId, orderId);
	}
	@Transactional
	@Override
	public void addRoom(int customerId, int roomId) {
		customerDao.addRoom(customerId, roomId);
		
	}

}
