package com.codingdojo.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HumanController {
	
	@RequestMapping("")
	public String index(
		Model model,
		@RequestParam(value="first_name", defaultValue="Human", required=false) String firstName,
		@RequestParam(value="last_name", required=false) String lastName){
		
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		
		return "index.jsp";
	}	
	
	// http://localhost:8080/	
	// http://localhost:8080/?first_name=Ronghuan
	// http://localhost:8080/?first_name=Ronghuan&last_name=You
}
