package com.comercial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.dao.ProductDao;
import com.comercial.model.Products;

@Service
public class ProductService {
	
	@Autowired
	ProductDao product;

	@Transactional
	public List<Products> getList (){
		
		List<Products> lista= product.getList();

		return lista;

	}
	
}
