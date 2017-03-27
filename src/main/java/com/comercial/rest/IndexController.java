package com.comercial.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message;
	
	@RequestMapping("/")
	public String getIndexPage(){
		return "/layout/backoffice";
	}
	
	
	/*Retornar un 
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	*/
	
		
	
}
