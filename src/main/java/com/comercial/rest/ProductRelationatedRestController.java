package com.comercial.rest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.model.RelationatedProduct;
import com.comercial.service.RelationatedProductService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/relationated_product")
public class ProductRelationatedRestController {
	
	private final RelationatedProductService relationatedProductService;

	@Autowired
	ProductRelationatedRestController(RelationatedProductService relationatedProductService) {
		this.relationatedProductService = relationatedProductService;
	}
	
	@RequestMapping(value = "/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countAll(){

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", relationatedProductService.count());	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countByParam(@RequestParam Map<String,String> requestParams) {

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", relationatedProductService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String relationatedProduct(@RequestParam Map<String,String> requestParams) {

		Page<RelationatedProduct> list = relationatedProductService.findAll(requestParams);
		
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

    @RequestMapping( method = RequestMethod.POST)
    public String createUser(@RequestBody RelationatedProduct relationatedProduct, UriComponentsBuilder ucBuilder) {
		
    	//LocalDateTime now = LocalDateTime.now();
        /*System.out.println("Before : " + now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        System.out.println("After : " + formatDateTime);
        */
    	
    	relationatedProduct.setCreatedAt(new Date());
    	relationatedProduct.setUpdatedAt(new Date());
    	
    	RelationatedProduct proTemp = relationatedProductService.save(relationatedProduct);
		
		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", proTemp.getIdRelationatedProduct());
		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String updateProduct(@RequestBody RelationatedProduct relationatedProduct, UriComponentsBuilder ucBuilder) {
    	
    	relationatedProduct.setUpdatedAt(new Date());
    	RelationatedProduct relationatedProductRes = relationatedProductService.save(relationatedProduct);
		
		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", relationatedProductRes.getIdRelationatedProduct());	    

		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findProduct(@PathVariable("id") String id, UriComponentsBuilder ucBuilder) {
		
		//poner el controlador de errores para cuando pase por aqui y no mande como id un numero
    	Long aa =  Long.parseLong(id);
		RelationatedProduct proTemp = relationatedProductService.findOne(aa);
		//System.out.println(proTemp);
		if (proTemp == null) {

            
            Map<String, String> toParse = new HashMap<String, String>();
    	    toParse.put("message", "Producto con id " + id  +" no existe, favor corregir");
    		JSONObject jsonObject = new JSONObject(toParse);
            
            return new ResponseEntity<Object>(jsonObject, HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<Object>(proTemp, HttpStatus.OK);
        }
	        
		
    }
    
	/*private void validateUser(Long userId) {
		this.relationatedProductService.findOne(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}*/
	

}




