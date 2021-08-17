package com.ronghuan.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronghuan.productscategories.models.Category;
import com.ronghuan.productscategories.models.Product;
import com.ronghuan.productscategories.repositories.CategoryRepository;
import com.ronghuan.productscategories.repositories.ProductRepository;

@Service
public class MainService {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	// -------------------- CRUD PRODUCTS  --------------------
	// read all
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	// read one
	public Product getProduct(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	// create & update
	public Product saveProduct(Product p) {
		return productRepo.save(p);
	}
	
	// get a list of products a particular product doesn't belong to
	public List<Product> getProductsByCategory(Category c){
		return productRepo.findByCategoriesNotContains(c);
	}
	
	
	// -------------------- CRUD CATEGORY  --------------------
	// create & update
	public Category saveCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	
	// read one
	public Category getCategory(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	// get a list of categories a particular product doesn't belong to
	public List<Category> getCategoriesByProduct(Product p){
		return categoryRepo.findByProductsNotContains(p);
	}
}
