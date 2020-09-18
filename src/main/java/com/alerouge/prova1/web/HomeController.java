package com.alerouge.prova1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String welcomePage(){
		return "home";
	}
	
}
