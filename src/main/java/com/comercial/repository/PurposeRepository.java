package com.comercial.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import com.comercial.model.Purpose;

public interface PurposeRepository extends CrudRepository<Purpose, Long> , QueryDslPredicateExecutor<Purpose> {

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
	public Page<Products> findAll(Predicate predicate, Pageable p);
	
	public long count(Predicate predicate);
	*/
	
}
