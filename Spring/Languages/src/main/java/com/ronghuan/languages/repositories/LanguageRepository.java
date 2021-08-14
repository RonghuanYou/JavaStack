package com.ronghuan.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronghuan.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
//	List<Language> findByDescriptionContaining(String search);

	
	
}
