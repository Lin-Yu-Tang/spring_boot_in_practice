package com.example.testregisterform.service;

import java.util.List;

import com.example.testregisterform.entity.User;

public interface UserService {
	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
	
}
