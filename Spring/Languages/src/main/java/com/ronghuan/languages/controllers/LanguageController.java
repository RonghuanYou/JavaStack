package com.ronghuan.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ronghuan.languages.models.Language;
import com.ronghuan.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageServ;
	
	// DISPLAY ALL LANGUAGES AND FORM TO CREATE LANGUAGE
	// emptyLanguage: for show create-form
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("languageObj") Language emptyLanguage) {
		List<Language> allLanguages = languageServ.allLanguages();
		model.addAttribute("languages", allLanguages);
		return "all_languages.jsp";
	}
	
	
	// PERFORM THE ACTION OF CREATING LANGUAGE
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("languageObj") Language filledLanguage, BindingResult results, Model model) {
		// VALIDATION
		if (results.hasErrors()) {
			// still show all languages when errors occur
			List<Language> allLanguages = languageServ.allLanguages();
			model.addAttribute("languages", allLanguages);
			return "all_languages.jsp";
		} else {
			languageServ.saveLanguage(filledLanguage);
			return "redirect:/languages";
		}
	}
	
	// DISPLAY SINGLE LANGUAGE
	@GetMapping("/languages/{id}")
	public String readLanguage(Model model, @PathVariable("id") Long id) {
		Language language = languageServ.getLanguage(id);
		model.addAttribute("language", language);
		return "language.jsp";
	}
	
	
	// DISPLAY EDIT PAGE TO EDIT SPECIFIC LANGUAGE
	@GetMapping("/languages/{id}/edit")
	public String edit(
		Model model,
		@PathVariable("id") Long id,
		@ModelAttribute("languageObj") Language filledLanguage) {
		// FIND SPECIFIC LANGUAGE AND SHOW ITS FORM TO EDIT
		Language language = languageServ.getLanguage(id);
		// show all values we have filled
		model.addAttribute("languageObj", language);
		return "edit.jsp";
	}
	
	
	// PERFORMING THE ACTION OF UPDATING LANGUAGE
	@PutMapping("/languages/{id}")
	public String update(
			Model model, 
			@Valid @ModelAttribute("languageObj") Language filledLanguage,
			BindingResult results) {
		// VALIDATIONS FAIL, RERENDER THE JSP
		if (results.hasErrors()) {
			List<Language> allLanguages = languageServ.allLanguages();
			model.addAttribute("languages", allLanguages);
			return "edit.jsp";
		// VALIDATIONS PASS, UPDATE LANGUAGE
		} else {
			languageServ.saveLanguage(filledLanguage);
			return "redirect:/languages";
		}
	}

	
	// DELETE LANGUAGE
	@GetMapping("/languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		languageServ.delete(id);
		return "redirect:/languages";
	}
	
	
	
	
	
	
	
	

	
	
	
}
