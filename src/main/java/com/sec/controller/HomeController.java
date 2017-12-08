package com.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/bloggers")
	public String bloggers(){
		return "bloggers";
	}
	
	@RequestMapping("/stories")
	public String stories(){
		return "stories";
	}
}
