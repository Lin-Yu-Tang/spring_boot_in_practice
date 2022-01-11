package com.example.testregisterform.controller;

import javax.websocket.server.PathParam;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class HomeController {
	
	@GetMapping("")
	public String homeForForm() {
		return "/form";
	}
	
	@PostMapping("/register")
	public String proccessForm(@RequestParam("user-name") String username,
							@RequestParam("user-password") String password) {
		System.out.println("proccess form");
		System.out.println("user: " + username);
		System.out.println("pass: " + password);
		
		
		return "form-result";
	}
	
	@GetMapping("/hello/{id}")
	public String hello(@PathParam("id") String id) {
		
		System.out.println("Path param: " + id );
		
		
		
		
		return "hello";
	}
	
	
	
	
	
	
	
	
	
	
}
