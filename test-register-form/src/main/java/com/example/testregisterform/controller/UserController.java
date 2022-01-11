package com.example.testregisterform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.example.testregisterform.entity.User;
import com.example.testregisterform.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	UserController(UserService service){
		this.userService = service;
	}
	
	@GetMapping("")
	public String userHome() {
		return "user/user-login";
	}
	
	
	/**
	 * 使用者註冊頁面
	 */
	@GetMapping("/register")
	public String userRegister(Model model) {
		System.out.println("visit user register");
		
		User theUser = new User();
		
		model.addAttribute("user", theUser);
		
		return "user/user-register";
	}
	
	
	/**
	 * 使用者註冊表單寫入資料庫
	 */
	@PostMapping("/process-form")
	public String processUserRegister(@ModelAttribute User user) {
		
		// generate hashpw by bcrypt
		String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
		
		// set password encrypt
		user.setPassword(hashpw);
		
		// sava to db
		userService.save(user);
		
		return "redirect:/user";
	}
	
	
	/**
	 * 使用者登入
	 */
	@PostMapping("/login")
	public String userLogin(
			@RequestParam("user-name") String username,
			@RequestParam("user-password") String password
			) {
		System.out.println("user login page");
		String resPage = "redirect:/user";
		
		List<User> users = userService.findAll();
		
		int indx = -1;
		
		for (int i = 0; i <users.size(); i++) {
			
			if (username.equals(users.get(i).getName())) {
				indx = i;
				break;
			}
		}
		
		if (indx != -1) {
			boolean b = BCrypt.checkpw(password, users.get(indx).getPassword());
			
			if (b) {
				System.out.println("[驗證成功]:user " + username +" login");
				resPage = "user/user-home";
			}
		}
		return resPage;
	}
}
