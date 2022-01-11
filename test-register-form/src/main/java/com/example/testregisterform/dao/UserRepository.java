package com.example.testregisterform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testregisterform.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	
}
