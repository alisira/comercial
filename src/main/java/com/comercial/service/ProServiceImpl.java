package com.comercial.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.model.Products;
import com.comercial.repository.ProductRepository;



@Service("ProService")
@Transactional
public class ProServiceImpl implements ProductService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Products> products;
	
	@Autowired
	private ProductRepository productsRepository;
	

	public List<Products> findAllProducts() {
		return (List<Products>) productsRepository.findAll();
	}

	public Products findById(Long id) {
		return productsRepository.findOne((long) id);
	}
	
	public Products findByName(String name) {
		return productsRepository.findByName(name);
	}
	
	@Override
	public Products saveProducts(Products products) {	
		return productsRepository.save(products);
	}

	public Products updateProducts(Products products) {
		return productsRepository.save(products);
	}

	public void deleteProductsById(long id) {
		productsRepository.delete(id);
	
	}

	public boolean isProductsExist(Products products) {
		return findByName(products.getName())!=null;
	}
	
	public void deleteAllProducts(){
		productsRepository.deleteAll();
	}

	public Long countByName(String name){
		return productsRepository.countByName(name);
	}

	@Override
	public long count() {
		return productsRepository.count();
	}

	@Override
	public Page pagination(Pageable pageable) {
		return productsRepository.findAll(pageable);
	}


	



}
