package com.comercial.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.comercial.model.Products;
import com.comercial.repository.ProductRepository;

public interface ProductService {
	
	Products findById(Long aa);
	
	long count();
	
	Products findByName(String name);
	
	Products saveProducts(Products products);
	
	Products updateProducts(Products products);
	
	void deleteProductsById(long id);

	List<Products> findAllProducts(); 
	
	void deleteAllProducts();
	
	public boolean isProductsExist(Products products);
	
	public Page pagination(Pageable pageable);

	public Long countByName(String string);
	
}
