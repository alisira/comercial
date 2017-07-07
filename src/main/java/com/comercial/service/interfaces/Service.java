package com.comercial.service.interfaces;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.types.dsl.BooleanExpression;

public interface Service {
	
	public String findAll(@RequestParam Map<String,String> requestParams) ;
	public long count();	
	public long count(@RequestParam Map<String,String> requestParams);
	public BooleanExpression criteryConstructor(Map<String,String> requestParams);
	
}
