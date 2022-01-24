package com.example.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.thymeleafdemo.dao.DepartmentRepository;
import com.example.thymeleafdemo.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository deptRepo;
	
	public DepartmentServiceImpl(DepartmentRepository repo) {
		this.deptRepo = repo;
		}
	
	@Override
	public List<Department> findAll() {
		return deptRepo.findAll();
	}

	@Override
	public Department findById(int theId) {
		
		Optional<Department> result = deptRepo.findById(theId);
		
		Department dept = null;
		
		if (result.isPresent())
			dept = result.get();
		else
			throw new RuntimeException("Did not find Department id - " + theId);
		
		return dept;
	}

	@Override
	public void save(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public void deleteById(int theId) {
		deptRepo.deleteById(theId);
	}

}
