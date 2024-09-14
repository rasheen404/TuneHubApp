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
			return "registerSuccess";
		} else {
			System.out.println("Email id already exist");
			return "registerFail";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password) {
		boolean loginStatus = userService.validateUser(email, password);

		if (loginStatus == true) {

			System.out.println("Login successfull");
			String role = userService.getRole(email);
			if (role.equals("admin")) {
				return "adminHome";
			} else {
				return "customerHome";
			}
		} else {
			System.out.println("Login failed");
			return "loginFail";

		}
	}
}
