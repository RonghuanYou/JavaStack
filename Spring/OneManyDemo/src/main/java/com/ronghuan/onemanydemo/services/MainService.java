package com.ronghuan.onemanydemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronghuan.onemanydemo.models.Sale;
import com.ronghuan.onemanydemo.models.User;
import com.ronghuan.onemanydemo.repositories.SaleRepository;
import com.ronghuan.onemanydemo.repositories.UserRepository;

@Service
public class MainService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SaleRepository saleRepo;
	
	// ------------------------- CRUD FOR USERS ---------------------
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User saveUser(User u) {
		return userRepo.save(u);
	}
	
	// READ ONE USER
	public User readUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	// DELETE
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	
	// ------------------------- CRUD FOR SALES ----------------------------
	// WE DON'T INCLUDE READ SALES SINCE WE CAN ACCESS IT BY USER
	public Sale saveSale(Sale s) {
		return saleRepo.save(s);
	}
	
	// DELETE 
	public void deleteSale(Long id) {
		saleRepo.deleteById(id);
	}
	

	
}
