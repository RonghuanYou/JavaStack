package com.ronghuan.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ronghuan.dojoninjas.models.Dojo;
import com.ronghuan.dojoninjas.models.Ninja;
import com.ronghuan.dojoninjas.services.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mainServ;
	
	
	// ----------------------- DOJO CRUD -------------------------------
	// SHOW FORM TO CREATE NEW DOJO
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojosObj") Dojo emptyDojo) {
		return "createDojo.jsp";
	}
	
	
	// PERFORM THE ACTION OF CREATING A NEW DOJO
	@PostMapping("/dojos/new")
	public String createDojo(
		@Valid @ModelAttribute("dojosObj") Dojo filledDojo,
		BindingResult results,
		Model model) {
		// validation
		if (results.hasErrors()) {
			return "createDojo.jsp";
		} else {
			// get user input new dojo info and create it in db
			mainServ.saveDojo(filledDojo);
			return "redirect:/dojos/new";
		}
	}
	
	// HAVE A DOJO SHOWS INFO OF ALL NINJAS THAT BELONG TO SPECIFIC LOCATION
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", mainServ.getDojo(id));
		return "dojo.jsp";
	}
	
	// ----------------------- NINJA CRUD -------------------------------
	// SHOW FORM TO CREATE NEW NINJA
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjasObj") Ninja emptyNinja, Model model) {
		model.addAttribute("dojos", mainServ.getAllDojos());
		return "createNinja.jsp";
	}
	
	
	// PERFORM THE ACTION OF CREATING A NEW NINJA
	@PostMapping("/ninjas/new")
	public String createNinja(
		@Valid @ModelAttribute("ninjasObj") Ninja filledNinja,
		BindingResult results) {
		if (results.hasErrors()) {
			return "createNinja.jsp";			
		} else {
			// create it in db
			mainServ.saveNinja(filledNinja);
			return "redirect:/ninjas/new";
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
