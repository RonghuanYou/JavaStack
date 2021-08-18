package com.ronghuan.loginregistrationdemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ronghuan.loginregistrationdemo.models.User;
import com.ronghuan.loginregistrationdemo.services.MainService;
import com.ronghuan.loginregistrationdemo.validators.UserValidator;

@Controller
public class MainController {
	@Autowired
	private MainService mainServ;
	
	@Autowired
	private UserValidator userValidator;
	
	// --------------------------- HOME PAGE -----------------------------
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
		Long userId = (Long) session.getAttribute("user_id");
		User user = mainServ.findUserById(userId);
		model.addAttribute("user", user);
		return "homePage.jsp";

    }
    
	// -------------------------- REGISTRATION CREATE --------------------------
    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("userObj") User emptyUser) {
        return "registration.jsp";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("userObj") User filledUser, BindingResult result,
    	HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	// else, save the user in the database, save the user id in session, and redirect them to the /home route

    	// PASS FILLED USER OBJCT COMMING FROM FORM AND BINDING RESULT
        userValidator.validate(filledUser, result);

    	if (result.hasErrors()) {
            return "registration.jsp";
        } else {
        	// SAVE FILLEDUSER IN DB AND STORE IT IN VARIABLE CALLED newUser
        	User newUser = mainServ.registerUser(filledUser);
        	// SAVE USER_ID IN SESSION
        	session.setAttribute("user_id", newUser.getId());
        	return "redirect:/home";
        }
    }    
    
	// -------------------------- LOGIN --------------------------
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    
    @PostMapping("/login")
    public String loginUser(
    	@RequestParam("email") String email, @RequestParam("password") String password, 
    	Model model, 
    	HttpSession session,
    	RedirectAttributes flashMessages) {
        // if the user is authenticated, save their user id in session
    	// else, add error messages and return the login page
    	if (mainServ.authenticateUser(email, password)) {
    		User loggedUser = mainServ.findByEmail(email);
    		session.setAttribute("user_id", loggedUser.getId());
    		return "redirect:/home";
    	} else {
    		flashMessages.addFlashAttribute("error", "INVALID LOGIN");
    		return "redirect:/login";
    	}
    }
    
    
    // --------------------------  LOGOUT -------------------------- 
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}
