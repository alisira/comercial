package com.comercial.rest;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.service.CategoryService;


@RestController
@RequestMapping(value = "/category")
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/category/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  String count() {

		long lista = categoryService.count();

	    Map<String, Long> toParse = new HashMap<String, Long>();
	    toParse.put("count", lista);
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCategory(@RequestParam Map<String,String> requestParams) {    	    	

		return categoryService.findAll(requestParams);

    }

}

