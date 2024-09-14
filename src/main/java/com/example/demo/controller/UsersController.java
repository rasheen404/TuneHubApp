package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entites.Users;
import com.example.demo.services.UsersService;

@Controller
public class UsersController {

	@Autowired
	UsersService userService;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		Boolean userStatus = userService.emailExist(user.getEmail());

		if (userStatus == false) {
			userService.addUser(user);
			System.out.println("User created successfully.");
		} else {
			System.out.println("User already Exist.");
		}
		return "home";
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password) {
		boolean loginStatus = userService.validateUser(email, password);

		if (loginStatus == true) {
			System.out.println("Login successfull");
			return "home";
		} else {
			System.out.println("Login failed");
			return "login";

		}
	}
}
