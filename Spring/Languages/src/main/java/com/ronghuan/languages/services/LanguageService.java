package com.ronghuan.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ronghuan.languages.models.Language;
import com.ronghuan.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository LanguageRepo;

	
	// CONSTRUCTORS
	public LanguageService(LanguageRepository languageRepo) {
		LanguageRepo = languageRepo;
	}
	
	
	// METHODS
	// CREATE & UPDATE
	public Language saveLanguage(Language l) {
		return LanguageRepo.save(l);
	}
	
	// GET ALL
	public List<Language> allLanguages(){
		return LanguageRepo.findAll();
	}


	// GET ONE
	public Language getLanguage(Long id) {
		return LanguageRepo.findById(id).orElse(null);
	}
		
	
	// DELETE
	public void delete(Long id) {
		LanguageRepo.deleteById(id);
	}
	

}
