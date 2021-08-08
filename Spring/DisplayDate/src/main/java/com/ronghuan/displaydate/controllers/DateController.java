package com.ronghuan.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class DateController {
	
	@RequestMapping("/")
	public String index (){
		return "index.jsp";
	}
	
	
	@RequestMapping("/date")
	public String date (Model model){
		
		// INSTANTIATE A DATE OBJECT
		Date date = new Date();
		
		String pattern = "EEEE, 'the' dd 'of' MMMM, YYYY";
		
		// INSTANTIATE A FORMAT OBJECT
		SimpleDateFormat formattedDate = new SimpleDateFormat(pattern);
		
		// PASS ATTRIBUTE
		model.addAttribute("currentDate", formattedDate.format(date));		
		return "date.jsp";
		
	}
	
	
	@RequestMapping("/time")
	public String time (Model model){
		Date date = new Date();
		String pattern = "h:mm a";
		SimpleDateFormat formattedDate = new SimpleDateFormat(pattern);
		
		// PASS ATTRIBUTE
		model.addAttribute("currentTime", formattedDate.format(date));	
		return "time.jsp";
	}
	
}
