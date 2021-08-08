package com.ronghuan.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class CodeController {
	// RETURN A LIST OF STRINGS
	private String[] getTenets() {
		return new String[] {"Loyalty", "Courage", "Veracity", "Compassion", "Honor"};
	}

	// DISPLAY HOME PAGE
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// GET POST CONTENTS
	@RequestMapping(value="/guess", method=RequestMethod.POST)
	public String guess(
			Model model,
			@RequestParam(value="guessValue") String guessValue, 
			RedirectAttributes redirectAttributes) {
		// guessValue is the value user inputs, if it's true, redirect to code page
		if (guessValue.equals("bushido")) {
			return "redirect:/code";
		}
		// if code is wrong, display error message
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	
	// DISPLAY CODE PAGE
	@RequestMapping("/code")
	public String code(Model model) {
		// PASS ARGS
		model.addAttribute("tenets", getTenets());
		return "code.jsp";
	}
}
