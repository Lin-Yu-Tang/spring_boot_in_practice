package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("hello")
	public String home(Model model) {
		
		model.addAttribute("yourName","林玉堂");
		model.addAttribute("date", new java.util.Date());
		
		
		return "hello";
	}
	
}
