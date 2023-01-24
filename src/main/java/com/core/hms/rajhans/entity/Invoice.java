package com.core.hms.rajhans.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Invoice{
	@Id
	private int id;
	private String customerName;
	private List<String> orders;
	private int total=0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public List<String> getOrders() {
		return orders;
	}



	public void setOrders(List<String> orders) {
		this.orders = orders;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "Invoice [customerName=" + customerName + ", orders=" + orders + ", total=" + total + "]";
	}
	
}
