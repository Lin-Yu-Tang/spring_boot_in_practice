package com.example.thymeleafdemo.service;

import java.util.List;

import com.example.thymeleafdemo.entity.Department;

public interface DepartmentService {
	
	public List<Department> findAll();
	
	public Department findById(int theId);
	
	public void save(Department dept);
	
	public void deleteById(int theId);
	
}
