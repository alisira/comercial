package com.comercial.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import com.comercial.model.Image;

public interface ImageRepository extends CrudRepository<Image, Long> , QueryDslPredicateExecutor<Image> {

	
}
