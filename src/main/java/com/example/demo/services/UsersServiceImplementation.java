package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Users;
import com.example.demo.repositories.UsersRepository;


@Service
public class UsersServiceImplementation implements UsersService{
	
	@Autowired
	UsersRepository userRepo;

	@Override
	public String addUser(Users user) {
		
		userRepo.save(user);
		
		return "User is created and saved";
	}

	
}
