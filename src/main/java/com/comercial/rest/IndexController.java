package com.comercial.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "backoffice";
	}	
		
	
}