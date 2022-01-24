package com.example.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleafdemo.entity.Department;
import com.example.thymeleafdemo.entity.Employee;
import com.example.thymeleafdemo.service.DepartmentService;
import com.example.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmpController {

	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService deptService;
	
	public EmpController(EmployeeService service) {
		this.employeeService = service;
	}
	
	
	@GetMapping("/list")
	public String listEmp(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		List<Department> department = deptService.findAll();
		
		model.addAttribute("employees", employees);
		model.addAttribute("department", department);
		
		return "emp/list-emp";
	}
	
	@GetMapping("/addForm")
	public String addForm(Model model) {
		
		Employee employee = new Employee();
		
		// bind form data
		model.addAttribute("employee", employee);
		
		return "emp/add-form";
	}
	
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("employee") Employee employee) {
		
		System.out.println("save emp");
		System.out.println(employee);
		
		
		// 不會檢查重覆PK，新增資料後，若PK重覆則變成update
		employeeService.save(employee);
		
		return "redirect:/employee/list";
	}
	
	
	@GetMapping("/detail")
	public String empDetail(@ModelAttribute("empno") int id, 
							Model model) {
		
		Employee emp = employeeService.findById(id);
		System.out.println(emp);
		
		model.addAttribute("employee", emp);
		
		return "emp/emp-detail";
	}
	
	@GetMapping("/update/{id}")
	public String empUpdate(@PathVariable(name = "id") int empno,
							Model model) {
		
		Employee emp = employeeService.findById(empno);
		
		model.addAttribute("employee", emp);
		
		return "emp/emp-update";
	}
	
	@GetMapping("/delete")
	public String empDelete(@RequestParam("empno") int empno) {
		
		Employee emp = employeeService.findById(empno);
		System.out.println("delete emp: ");
		System.out.println(emp);
		
		employeeService.deleteById(empno);
		
		return "redirect:/employee/list";
	}
	
	
	
	
	
	
	
	
	
}
