package com.core.hms.rajhans.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.core.hms.rajhans.entity.Customer;
import com.core.hms.rajhans.entity.Order;
import com.core.hms.rajhans.entity.Room;
import com.core.hms.rajhans.service.CustomerService;
import com.core.hms.rajhans.service.OrderService;
import com.core.hms.rajhans.service.RoomService;


@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private RoomService roomService;
	@GetMapping
	public String redirectList()  {
		return "redirect:/customers/list";
	}
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		List<Customer> theCustomers = customerService.listCustomer();
		theModel.addAttribute("customers",theCustomers);
		return "customers";
	}
	@GetMapping("/form")
	public String showFormAdd(Model model) {
		Customer theCustomer =new Customer();
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.addCustomer(theCustomer); 
		return "redirect:/customers/list";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)  {
		customerService.deleteCustomer(theId);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/update") 
	public String showFormForUpdate(@RequestParam("customerId")  int theId, Model theModel) {
	Customer theCustomer = customerService.findCustomer(theId);
	theModel.addAttribute("customer",theCustomer);
	return "customer-form";
	}
	@GetMapping("/order")
	public String orderForCustomer(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.findCustomer(theId);
		List<Order> theOrders = orderService.listOrder();
		List<Room> theRooms = roomService.listRoom();
		List<Order> myOrders = theCustomer.getOrders();
		theOrders.removeAll(myOrders);
		Room myRoom= theCustomer.getRoom();
		theModel.addAttribute("customer", theCustomer);
		theModel.addAttribute("orders",theOrders);
		theModel.addAttribute("myOrders",myOrders);
		theModel.addAttribute("rooms",theRooms);
		theModel.addAttribute("myRoom",myRoom );
		return "order-logs";
	}
	@GetMapping("/order/addo")
	public String addOrder(@RequestParam("customerId") int theId, @RequestParam("orderId") int theOrderId,Model theModel) {
		customerService.addOrder(theId, theOrderId);
		return "redirect:/customers/order?customerId="+theId;
	}
	@GetMapping("/order/addr")
	public String addRoom(@RequestParam("customerId") int theId, @RequestParam("roomId") int theRoomId,Model theModel) {
		customerService.addRoom(theId, theRoomId);
		return "redirect:/customers/order?customerId="+theId;
	}
}
