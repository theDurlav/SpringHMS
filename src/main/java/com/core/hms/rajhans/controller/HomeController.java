package com.core.hms.rajhans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
