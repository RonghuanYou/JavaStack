package com.ronghuan.loginregistrationdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronghuan.loginregistrationdemo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	
	// GET USER OBJECT BY A PARTICULAR EMAIL
	User findByEmail(String email);
}
