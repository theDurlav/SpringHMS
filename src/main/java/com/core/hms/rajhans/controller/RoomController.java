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
import com.core.hms.rajhans.service.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public String redirectList() {
		return "redirect:/rooms/list";
	}
	
	@GetMapping("/list")
	public String listRooms(Model model) {
		List<Room> theRooms = roomService.listRoom();
		model.addAttribute("rooms", theRooms);
		return "rooms";
	}
	@GetMapping("/form")
	public String showFormAdd(Model model) {
		Room theRoom = new Room();
		model.addAttribute("room",theRoom);
		return "room-form"; 
	}
	
	@PostMapping("/save")
	public String addRoom(@ModelAttribute("room") Room theRoom) {
		roomService.addRoom(theRoom);
		return "redirect:/rooms/list";
	}
	
	@GetMapping("/update")
	public String orderRoom(@RequestParam("roomId") int theId ,Model theModel) {
		Room theRoom = roomService.getRoom(theId);
		theModel.addAttribute("room" , theRoom);
		return "room-form";
	}
	@GetMapping("/delete")
	public String deleteRoom(@RequestParam("roomId") int theId) {
		roomService.deleteRoom(theId);
		return "redirect:/rooms/list";
	}
}
