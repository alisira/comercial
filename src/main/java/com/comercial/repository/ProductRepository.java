package com.comercial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.comercial.model.Products;
import com.querydsl.core.types.Predicate;

public interface ProductRepository extends CrudRepository<Products, Long> , QueryDslPredicateExecutor<Products> {

	Products findByName(String name);
	Iterable<Products> findAll(Sort sort);
	Page<Products> findAll(Pageable pageable);
	Long countByName(String name);
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
