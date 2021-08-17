package com.ronghuan.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronghuan.productscategories.models.Category;
import com.ronghuan.productscategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findAllByProducts(Product product);
	// Retrieve a list of any categories that one particular product doesn't belong to
	List<Category> findByProductsNotContains(Product product);

}
