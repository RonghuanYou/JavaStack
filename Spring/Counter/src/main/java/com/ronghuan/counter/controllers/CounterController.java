package com.ronghuan.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		// SET SESSION(IF COUNT IS NOT ALREADY IN SESSION)
		if (session.getAttribute("count").equals(null)) {
			// INITIALIZE COUNT IN SESSION
			session.setAttribute("count", 0);
		} else {
			// INCREASE THE COUNT BY 1 USING GET/SET
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 1;
			// SET NEW COUNT INTO SESSION 
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		// PASS PARAMETER
		model.addAttribute("currentCount", currentCount);
		return "counter.jsp";
	}
	
}
