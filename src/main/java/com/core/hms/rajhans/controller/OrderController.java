package com.core.hms.rajhans.controller;

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

import com.core.hms.rajhans.entity.Order;
import com.core.hms.rajhans.entity.Room;
import com.core.hms.rajhans.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public String redirectList() {
		return "redirect:/orders/list";
	}
	
	@GetMapping("/list")
	public String listOrders(Model model) {
		List<Order> theOrders= orderService.listOrder();
		model.addAttribute("orders", theOrders);
		return "orders";
	}
	@GetMapping("/form")
	public String showFormAdd(Model model) {
		Order theOrder = new Order();
		model.addAttribute("order",theOrder);
		return "order-form";
	}
	
	@PostMapping("/save")
	public String addOrder(@ModelAttribute("order") Order theOrder) {
		orderService.addOrder(theOrder);
		return "redirect:/orders/list";
	}
	
	@GetMapping("/update")
	public String updateOrder(@RequestParam("orderId") int theId, Model theModel) {
		Order theOrder = orderService.getOrder(theId);
		theModel.addAttribute("order",theOrder);
		return "order-form";
	}
	@GetMapping("/delete")
	public String deleteOrder(@RequestParam("orderId") int theId) {
		orderService.deleteOrder(theId);
		return "redirect:/orders/list";
	}
}
