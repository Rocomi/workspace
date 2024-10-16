package com.kh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PracticeController {
	
	// /practice
	@GetMapping("/practice")
	public String practicePage(Model m, HttpSession session) {
		
		// request scope에 데이터 저장
		m.addAttribute("name", "엄희윤");
		m.addAttribute("title","<h3>Hello, Thymeleaf~</h3>");
		
		// session scope에 데이터 저장 => Httpsession
		session.setAttribute("age", 30);
		
		return "practice";	// templates/"practice".html
	}
	
	@GetMapping("/test")
	public String testPage() {
		
		
		return "main";	// templates/practice.html
	}

}
