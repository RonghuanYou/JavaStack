package com.ronghuan.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronghuan.productscategories.models.Category;
import com.ronghuan.productscategories.models.Product;
import com.ronghuan.productscategories.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainServ;
	
	// ----------------------------- PRODUCT ------------------------------
	// CREATE NEW PRODUCT
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("productsObj") Product emptyProduct) {
		return "newProduct.jsp";
	}

	
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("productsObj") Product filledProduct) {
		mainServ.saveProduct(filledProduct);
		return "redirect:/products/new";
	}
	
	// ADD PRODUCT TO CATEGORIES IT DOESN'T ALREADY BELONG TO (CREATING RELN)
	@GetMapping("/products/{id}")
	public String oneProduct(@PathVariable("id") Long id, Model model) {
		Product oneProduct = mainServ.getProduct(id);
		model.addAttribute("product", oneProduct);
		model.addAttribute("categories", mainServ.getCategoriesByProduct(oneProduct));
		
		return "product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(
		@PathVariable("id") Long pro_id,
		@RequestParam("category_id") Long cat_id) {
		// FIND SPECIFIC PRODUCT AND CATEGORY USING IDS
		Category oneCategory = mainServ.getCategory(cat_id);
		Product oneProduct = mainServ.getProduct(pro_id);
		
		// ADD THE RELATIONSHIP TO OBJS
//		oneCategory.getProducts().add(oneProduct);
		oneProduct.getCategories().add(oneCategory);

		// SAVE NEW INFO IN DB
//		mainServ.saveCategory(oneCategory);
		mainServ.saveProduct(oneProduct);
			
		return "redirect:/products/" + pro_id;
	}

	// ----------------------------- CATEGORY ------------------------------
	// CREATE NEW CATEGORY
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("categoriesObj") Category emptyCategory) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute("categoriesObj") Category filledCategory) {
		mainServ.saveCategory(filledCategory);
		return "redirect:/categories/new";
	}
	
	// SHOW THE PAGE: ADD CATEGORIES TO PRODUCT 
	@GetMapping("/categories/{id}")
	public String oneCategory(Model model, @PathVariable("id") Long id) {
		// get one category and all products
		Category oneCategory =  mainServ.getCategory(id);
		model.addAttribute("category", oneCategory);
		model.addAttribute("products", mainServ.getProductsByCategory(oneCategory));
		
		return "category.jsp";
	}
	
	// 
	@PostMapping("/categories/{id}")
	public String addProductToCategory(
		@PathVariable("id") Long cat_id,
		@RequestParam("product_id") Long prod_id) {
		// get category id and product id
		Category oneCategory = mainServ.getCategory(cat_id);
		Product oneProduct = mainServ.getProduct(prod_id);
		
		// choose products for category, add 
		oneCategory.getProducts().add(oneProduct);
		mainServ.saveCategory(oneCategory);

		
		return "redirect:/categories/" + cat_id;
	}
	
	
	
	
	
}
