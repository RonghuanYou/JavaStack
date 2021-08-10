package com.ronghuan.dojosurvey.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ronghuan.dojosurvey.models.DojoSurvey;


@Controller
public class DojoController {
	// ARRAY OF STRINGS TO STORE NAMES OF PEOPLE WHO LIKE JAVA
    	ArrayList<String> peopleLikeJava = new ArrayList<String>();
	
	// DISPLAY THE DOJO SURVEY FORM
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	// PERFORM THE ACTION OF CREATING FORM
	@PostMapping("/survey")
	//@PostMapping("/survey")
	public String create(
		Model model,
		RedirectAttributes redirectAttributes,
		@RequestParam(value="name") String name,
		@RequestParam(value="location") String location,
		@RequestParam(value="language") String language,
		@RequestParam(value="comment") String comment)
	{
		// FIND PEOPLE WHO LIKE JAVA, PUSH ITS NAME INTO ARRAY CALLED peopleLikeJava
		if (language.equals("Java")) {
			peopleLikeJava.add(name);
		}
		
		redirectAttributes.addFlashAttribute("result", new DojoSurvey(name, location, language, comment));
		return "redirect:/result";
	}
	

	// DISPLAY THE RESULT OF DOJO SURVEY FORM
	@RequestMapping("/result")
	public String result() {		
		return "result.jsp";
	}

	
	// DISPLAY NAME OF PERSON WHO CHOOSE "JAVA" AS THEIR FAVORITE LANGUAGE
	@RequestMapping("/javaliker")
	public String javaLiker(Model model) {
		model.addAttribute("nameArray", peopleLikeJava);
		return "java_liker.jsp";
	}
}
