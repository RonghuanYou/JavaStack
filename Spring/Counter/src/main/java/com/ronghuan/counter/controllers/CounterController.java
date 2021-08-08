package com.ronghuan.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	// PRIVATE GET/SET METHODS
	// RETURN SPECIFIC VALUE FROM SESSION
	private int getSessionValue(HttpSession session) {
		Object countVal = session.getAttribute("count");    // GET COUNT VALUE
		// SET SESSION(IF COUNT IS NOT ALREADY IN SESSION)
		if (countVal == null) {
			setSessionValue(session, 0);
			countVal = session.getAttribute("count");
		}
		return (Integer)countVal;
	}
	
	// SET/UPDATE VALUE IN SESSION
	private void setSessionValue(HttpSession session, int value) {
		session.setAttribute("count", value);
	}
	
	// EVERY VISIT INCREASE COUNT NUM BY ONE
	@RequestMapping("/")
	public String index(HttpSession s) {
		int currentCount = getSessionValue(s);  // GET COUNT VALUE
		currentCount++;   			// INCREASE COUNT BY ONE 
		setSessionValue(s, currentCount);  	// SET NEW COUNT VALUE
		return "index.jsp"; 
	}
	
	// SHOW COUNTER PAGE AND DISPLAY NUM OF COUNTS
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		// PASS PARAMETER
		model.addAttribute("currentCount", getSessionValue(session));
		return "counter.jsp";
	}
	
	// INCREASING THE NUMBER OF VISITS OF HOME PAGE IN N TIMES
	@RequestMapping("/add/{times}")
	public String addTimes(HttpSession s, @PathVariable("times") String times) {
		int time = 0;
		// IF times IS NOT INT, THROW ERROR MESSAGE
		try {
			time = Integer.parseInt(times);			
		} catch(NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
			return "redirect:/";
		}
		
		
		int currentCount = getSessionValue(s);  // GET CURRETN COUNT NUM
		currentCount += time;			// INCREASE IT BY INPUT TIMES
		setSessionValue(s, currentCount);	// UPDATE COUNT NUM
		return "index.jsp";
	}
	
	// CLEAR SESSION
	@RequestMapping("/reset")
	public String reset(HttpSession s) {
		// REMOVE ALL ATTRIBUTES FROM SESSION OBJECT, RETURN TO COUNTER PAGE
		s.invalidate();
		return "redirect:/counter";
	}
	
}
