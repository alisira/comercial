package com.comercial.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.model.Products;
import com.comercial.repository.ProductRepository;
import com.querydsl.core.types.Predicate;

@Service("ProductService")
@Transactional
public interface ProductService extends ProductRepository , QueryDslPredicateExecutor<Products> {
	
	@Query("SELECT p FROM Products p WHERE p.name = :#{#pro.name}")
	List<Products> findAllByCustomProduct(@Param("pro") Products pro);
	
	@Query("SELECT p FROM Products p WHERE p.name = :#{#pro.name}")
	List<Products> findAllByCustomProduct(@Param("pro") Products pro, Pageable pageable);
	
	@Query("SELECT p FROM Products p WHERE p.name=:name")
	public List<Products> findAll(@Param("name") String name, Pageable p);	

	public Page<Products> findAll(Predicate predicate);
	public Page<Products> findAll(Predicate predicate, Pageable p);
	
	public long count(Predicate predicate);

	
	

}

