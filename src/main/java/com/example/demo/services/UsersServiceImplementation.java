package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {

	@Autowired
	UsersRepository userRepo;

	@Override
	public String addUser(Users user) {

		userRepo.save(user);

		return "User is created and saved";
	}

	@Override
	public Boolean emailExist(String email) {
		if (userRepo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean validateUser(String email, String password) {
		Users user = userRepo.findByEmail(email);
		String db_password = user.getPassword();

		if (db_password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		Users user = userRepo.findByEmail(email);
		String role = user.getRole();
		return role;
	}

}
