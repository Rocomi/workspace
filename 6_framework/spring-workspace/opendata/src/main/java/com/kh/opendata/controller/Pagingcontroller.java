package com.kh.opendata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pagingcontroller {
	
	@RequestMapping("/cityTemp")
	public String cityTemp() {
		return "cityTemp";
	}
	
	@RequestMapping("/airPollution")
	public String airPollution() {
		return "airPollution";
	}
	
	@RequestMapping("/shelter")
	public String shelter() {
		return "tsunamiShelter";
	}

}
