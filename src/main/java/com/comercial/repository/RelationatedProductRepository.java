package com.comercial.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.model.Category;
import com.comercial.model.Products;
import com.comercial.model.RelationatedProduct;
import com.querydsl.core.types.Predicate;

public interface RelationatedProductRepository extends CrudRepository<RelationatedProduct, Long> , QueryDslPredicateExecutor<RelationatedProduct> {

	void deleteByidRelationatedProduct(Integer idRelationatedProduct);
	void deleteByidProduct(@Param("idProduct") Products  products);
	
	
	//@Query("delete FROM RelationatedProduct WHERE idProduct.idProduct = :#{#id.idProduct}")
	//void deleteByidProduct(@Param("id") Products  ip);
	
	//@Query("delete FROM RelationatedProduct WHERE idProduct = :#{#id}")
	//void deleteByidProduct(@Param("id") Products  ip);
	
	

	/*Products findByName(String name);
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
	public Page<Products> findAll(Predicate predicate, Pageable p);*/
	
	public long count(Predicate predicate);
	//public long count(@RequestParam Map<String,String> requestParams);
	
	
}


