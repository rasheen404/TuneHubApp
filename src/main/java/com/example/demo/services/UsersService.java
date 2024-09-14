package com.example.demo.services;

import com.example.demo.entites.Users;

public interface UsersService {

	public String addUser(Users user);

	public Boolean emailExist(String email);
	
	public Boolean validateUser(String email , String password);
	
	public String getRole(String email);

}
