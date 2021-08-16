package com.ronghuan.dojoninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronghuan.dojoninjas.models.Dojo;
import com.ronghuan.dojoninjas.models.Ninja;
import com.ronghuan.dojoninjas.repositories.DojoRepository;
import com.ronghuan.dojoninjas.repositories.NinjaRepository;

@Service
public class MainService {
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// ------------------------------ CRUD FOR DOJOS ------------------------------
	// Create & update
	public Dojo saveDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// Read all
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	// Read one
	public Dojo getDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}

	
	//  ------------------------------ CRUD FOR NINJAS  ------------------------------
	// Create & update
	public Ninja saveNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	
	
	
}
