package com.comercial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.comercial.model.Products;

public interface ProductRepository extends CrudRepository<Products, Long>  {

	Products findByName(String name);
	Iterable<Products> findAll(Sort sort);
	Page<Products> findAll(Pageable pageable);
	Long countByName(String name);
	
}
