package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entites.Users;
import com.example.demo.services.UsersService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController {

	@Autowired
	UsersService userService;

	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {

		
		userService.addUser(user);
		return "home";
	}
}
