package com.core.hms.rajhans.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.hms.rajhans.entity.Customer;
import com.core.hms.rajhans.entity.Invoice;
import com.core.hms.rajhans.entity.Order;
import com.core.hms.rajhans.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/invoice")
public Invoice  getInvoice(@RequestParam("customerId") int Id) {
		Customer customer = customerService.findCustomer(Id);
		Invoice invoice = new Invoice();
		invoice.setCustomerName(customer.getFirstName()+" "+customer.getLastName());
		List<String> orders = new ArrayList<>();
		int total=0;
		for(Order o : customer.getOrders()) {
			orders.add(o.getName()+ "  Price :"+ o.getPrice() +"");
			total+=o.getPrice();
		}
		invoice.setId(customer.getId());
		invoice.setOrders(orders);
		invoice.setTotal(total);
		return invoice;
	
	}
	

}
