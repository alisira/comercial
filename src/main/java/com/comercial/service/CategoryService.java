package com.comercial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.dao.CategoryDao;
import com.comercial.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao category;

	@Transactional
	public List<Category> getList (){
		
		List<Category> lista= category.getList();
		
		return lista;

	}
	
}