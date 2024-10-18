package com.kh.lclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.lclinic.model.vo.User;
import com.kh.lclinic.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService uService;
	
	@PostMapping("/login")
	public String loginUser(User user, HttpSession session) {
		
		System.out.println(user);
		
//		session.setAttribute("user", user);
		
		User loginUser = uService.loginUser(user);
		
		if (loginUser != null) {
			session.setAttribute("user", loginUser);
		}
		
		return "redirect:/";
	}

}