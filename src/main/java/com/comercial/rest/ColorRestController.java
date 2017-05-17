package com.comercial.rest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.model.Color;
import com.comercial.model.Products;
import com.comercial.model.RelationatedProduct;
import com.comercial.service.ColorService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;


@RestController
@RequestMapping("/color")
public class ColorRestController {

	@Autowired
	ColorService colorService;
	
	@RequestMapping( method = RequestMethod.POST)
    public String save(@RequestBody Color color, UriComponentsBuilder ucBuilder) {
    	
    	color.setCreatedAt(new Date());
    	color.setUpdatedAt(new Date());
    	
    	Color colorBack = colorService.save(color);
		
		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", colorBack.getIdColor());
		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }
	
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String findAll(@RequestParam Map<String,String> requestParams) {

		Iterable<Color> list = colorService.findAll(requestParams);
		
		ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {
			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return jsonInString ;

    }
	
	
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countByParam(@RequestParam Map<String,String> requestParams) {

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", colorService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}

    /*@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String listColor(@RequestParam Map<String,String> requestParams) {

    	List<Color> list = colorService.findAll(requestParams).getContent();
        
    	ObjectMapper mapper = new ObjectMapper();

    	String jsonInString = null;
		try {

			jsonInString = mapper.writeValueAsString(list);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return jsonInString ;

    }*/	
    
	@RequestMapping(value = "/print", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String print(@RequestParam Map<String,String> requestParams) throws IOException, DocumentException {
		
		System.out.println(112233);
		
		ParseHtml.main(new String[]{"a","b","c"});
		

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", colorService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
}

