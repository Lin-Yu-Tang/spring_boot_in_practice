package com.example.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.thymeleafdemo.dao.EmployeeRepository;
import com.example.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository repo) {
		employeeRepository = repo;
	}
	
	@Override
	public List<Employee> findAll() {
//		return employeeRepository.findAll();
		return employeeRepository.findAllByOrderBySalaryAsc();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee emp = null;
		
		if (result.isPresent()) 
			emp = result.get();
		else 
			throw new RuntimeException("Did not find employee id - " + theId);
		
		
		return emp;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
