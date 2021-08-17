package com.ronghuan.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronghuan.productscategories.models.Category;
import com.ronghuan.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	// Retrieve a list of any products that one particular category doesn't belong to
	List<Product> findByCategoriesNotContains(Category category);
}
