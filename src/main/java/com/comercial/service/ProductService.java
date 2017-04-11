package com.comercial.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.model.Category;
import com.comercial.model.Products;
import com.comercial.model.QProducts;
import com.comercial.repository.ProductRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("ProductService")
@Transactional
public class ProductService implements ProductRepository  {
	
	@Autowired
	private ProductRepository productsRepository;
	
	@Override
	public <S extends Products> S save(S entity) {
		
		if (entity.getIdProduct() != null){
			Products product = productsRepository.findOne(entity.getIdProduct());
			if (product != null){
	        	String[] nullPropertyNames = ServiceUtil.getNullPropertyNames(entity);
	            ServiceUtil.copyProperties(entity, product, nullPropertyNames);
	        }	
		}
		
		return productsRepository.save(entity);
	}

	@Override
	public <S extends Products> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products findOne(Long id) {
		return productsRepository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Products> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Products> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {		
		return productsRepository.count();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Products entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Products> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Products findOne(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Products> findAll(Predicate predicate, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterable<Products> findAll(Predicate predicate, OrderSpecifier<?>... orders) {		
		return null;
	}

	@Override
	public Iterable<Products> findAll(OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Predicate predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Products findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Products> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAllByCustomProduct(Products pro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAllByCustomProduct(Products pro, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAll(String name, Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Products> findAll(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Page<Products> findAll(@RequestParam Map<String,String> requestParams, Pageable page) {
		return productsRepository.findAll(criteryConstructor(requestParams), page);
	}
	
	@Override
	public Page<Products> findAll(Predicate predicate, Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Predicate predicate) {
		return productsRepository.count(predicate);
	}
	
	public long count(@RequestParam Map<String,String> requestParams) {
		return productsRepository.count(criteryConstructor(requestParams));
	}
	

	private BooleanExpression criteryConstructor(Map<String,String> requestParams){
    	
    	QProducts qpro = QProducts.products;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());
	        
	        BooleanExpression criterio = null;
	        if (e.getKey().equals("name")){
	        	criterio = qpro.products.name.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("description")){
	        	criterio = qpro.products.description.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("idCategory")){
	        	Category cat = new Category();
	    		cat.setIdCategory(Integer.parseInt(e.getValue().toString()));	        	
	        	criterio = qpro.products.idCategory.eq(cat);
	        }
	        
	        if (e.getKey().equals("code")){
	        	criterio = qpro.products.code.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }	        
	        
	        if (criterio != null){
	        	if (con == 0){
	        		criterioFinal = criterio;	
	        	}else{
	        		if (criterioFinal != null){
	        			criterioFinal = criterioFinal.and(criterio);
	        		}else{
	        			criterioFinal = criterio;
	        		}
	        	}
	        }
	        con++;
	    }
    	
		return criterioFinal;
    	
    }
	
	

}

