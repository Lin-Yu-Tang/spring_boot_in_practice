package com.example.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleafdemo.entity.Student;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	/**
	 * in memory case
	 */
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		
		Student s1 = new Student("0001", "林玉堂", "經濟系");
		Student s2 = new Student("0002", "鄭尹千", "經濟系");
		Student s3 = new Student("0003", "石鈺珍", "經濟系");
		
		students = new ArrayList<Student>();
		
		students.add(s1); students.add(s2); students.add(s3);
	}
	
	
	@GetMapping("list")
	public String listStudent(Model model) {
		
		model.addAttribute("students", students);
		
		return "student/list-students";
		
		
		
	}
	
	

}
