package com.comercial.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.Enviroment;
import com.comercial.model.Purpose;
import com.comercial.service.PurposeService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PurposeRestController {


	@Autowired
	PurposeService purposeService;	
	
	@RequestMapping(value = "/purpose/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  String count(){

		long lista = purposeService.count();
	    
	    Map toParse = new HashMap();
	    toParse.put("count", lista);
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();
		
	}	
	
	
	@RequestMapping(value = "/purpose/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String listPurpose(@RequestParam Map<String,String> requestParams) {
    	
		List<Purpose> lista = purposeService.findAll(requestParams);
        
    	ObjectMapper mapper = new ObjectMapper();


    	String jsonInString = null;
		try {

			jsonInString = mapper.writeValueAsString(lista);


		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return jsonInString ;

	}
    
}

