package com.ronghuan.onemanydemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ronghuan.onemanydemo.models.Sale;
import com.ronghuan.onemanydemo.models.User;
import com.ronghuan.onemanydemo.services.MainService;



@Controller
public class MainController {
	
	@Autowired
	private MainService mainServ;
	
	
	// ---------------------------------------------------- CREATE USER -----------------------------------------------------------
	@GetMapping("/")
	public String index(@ModelAttribute("userObj") User emptyUser) {
		return "index.jsp";
	}
	
	
	@PostMapping("/users/new")
	public String create(@ModelAttribute("userObj") User filledUser) {
		mainServ.saveUser(filledUser);
		return "redirect:/";
	}
	
	// ---------------------------------------------------- READ ONE EMPLOYEE -----------------------------------------------------
	@GetMapping("/users/{id}")
	public String readUser(@PathVariable("id") Long user_id, Model model) {		
		// GET SPECIFIC USER INFO, PASS INFO TO JSP
		model.addAttribute("user", mainServ.readUser(user_id));
		return "user.jsp";
	}
	// ---------------------------------------------------- DELETE ONE EMPLOYEE -----------------------------------------------------
	@GetMapping("users/{id}/delete")
	public String deleteUser(@PathVariable("id") Long user_id) {
		mainServ.deleteUser(user_id);
		return "redirect:/sales";
	}
	// ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------- CREATE SALES-----------------------------------------------------
	@GetMapping("/ç")
	public String newSale(@ModelAttribute("salesObj") Sale emptySale, Model model) {
		// GRAB ALL EMPLOYEES FROM DB
		List<User> allEmployees = mainServ.getAllUsers();
		// PASS EMPLOYESS TO JSP
		model.addAttribute("employees", allEmployees);
		return "sales.jsp";
	}
	
	// GET SALES INFO
	@PostMapping("/sales/new")
	public String createSale(@ModelAttribute("salesObj") Sale filledSale) {
		// SAVE SALE INFO IN DB
		mainServ.saveSale(filledSale);
		return "redirect:/";
	}
	
	
	// DELETE SALE
	@GetMapping("/sales/{id}/delete")
	public String deleteSale(@PathVariable("id") Long id) {
		mainServ.deleteSale(id);
		return "redirect:/sales";
	}
	
	// ------------------------------------------------------- SALE DASHBOARD ----------------------------------------------------
	@GetMapping("/sales")
	public String saleDashboard(Model model) {
		List<User> allUsers = mainServ.getAllUsers();
		model.addAttribute("employees", allUsers);
		return "saleDash.jsp";
	}
	

	
	
}
