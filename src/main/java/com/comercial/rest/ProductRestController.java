package com.comercial.rest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.model.Products;
import com.comercial.service.ProductService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ProductRestController {

	@Autowired
	ProductService productService;	
	
	@RequestMapping(value = "/product/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countAll(){

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", productService.count());	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
	
	@RequestMapping(value = "/product/count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countByParam(@RequestParam Map<String,String> requestParams) {

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", productService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
	
    @RequestMapping(value = "/product/list", method = RequestMethod.GET, produces = "application/json")
	//public @ResponseBody String product(@RequestParam(value ="page", defaultValue="") long page, @RequestParam(value ="perPage", defaultValue="") long perPage){@RequestParam Map<String,String> requestParams
    public @ResponseBody String product(@RequestParam Map<String,String> requestParams) {

		Pageable pageable = new PageRequest(Integer.parseInt(requestParams.get("page"))-1, Integer.parseInt(requestParams.get("perPage")),new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "name")));
		Page<Products> ll = productService.findAll(requestParams ,pageable);
		
		ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {
			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ll.getContent());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return jsonInString ;

    }   
	
    @RequestMapping(value = "/product/listDetail", method = RequestMethod.GET, produces = "application/json")
	//public @ResponseBody String product(@RequestParam(value ="page", defaultValue="") long page, @RequestParam(value ="perPage", defaultValue="") long perPage){@RequestParam Map<String,String> requestParams
    public @ResponseBody String product2(@RequestParam Map<String,String> requestParams) {

		Page<Products> list = productService.findAll(requestParams);
		
		ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {
			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list.getContent());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return jsonInString ;

    }
    
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public String createUser(@RequestBody Products product, UriComponentsBuilder ucBuilder) {
		
    	//LocalDateTime now = LocalDateTime.now();
        /*System.out.println("Before : " + now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        System.out.println("After : " + formatDateTime);
        */
    	
    	System.out.println(product.getIdStatus());
    	
    	product.setCreatedAt(new Date());
    	product.setUpdatedAt(new Date());
    	
    	Products proTemp = productService.save(product);
		
		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", proTemp.getIdProduct());
		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }
    
    @RequestMapping(value = "/product/", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Products product, UriComponentsBuilder ucBuilder) {

    	product.setUpdatedAt(new Date());
    	Products productRes = productService.save(product);
		
		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", productRes.getIdProduct());	    

		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    //public ResponseEntity<Void> findProduct(@RequestBody String product, @PathVariable("id") long id, UriComponentsBuilder ucBuilder) {
    public String findProduct(@PathVariable("id") String id, UriComponentsBuilder ucBuilder) {
		
		//poner el controlador de errores para cuando pase por aqui y no mande como id un numero
    	Long aa =  Long.parseLong(id);
		Products proTemp = productService.findOne(aa);		

		ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(proTemp);
			
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




