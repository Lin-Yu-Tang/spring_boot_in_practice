package com.example.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleafdemo.entity.Employee;

														// entity type , type of primary key
public interface EmployeeRepository extends JpaRepository<Employee	, Integer>{
	
	
	
	// sort method
	public List<Employee> findAllByOrderBySalaryAsc();
}
