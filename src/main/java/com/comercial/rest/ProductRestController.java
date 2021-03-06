package com.comercial.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.comercial.model.Products;
import com.comercial.model.RelationatedProduct;
import com.comercial.service.ProductService;
import com.comercial.service.RelationatedProductService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/product")
public class ProductRestController {

	private final ProductService productService;
	private final RelationatedProductService relationatedProductService;

	@Autowired
	ProductRestController(ProductService productService, RelationatedProductService relationatedProductService ) {
		this.productService = productService;
		this.relationatedProductService = relationatedProductService;
	}


	@RequestMapping(value = "/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countAll(){

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", productService.count());	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
	
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countByParam(@RequestParam Map<String,String> requestParams) {

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", productService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	//public @ResponseBody String product(@RequestParam(value ="page", defaultValue="") long page, @RequestParam(value ="perPage", defaultValue="") long perPage){@RequestParam Map<String,String> requestParams
    public @ResponseBody String product(@RequestParam Map<String,String> requestParams) {

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

    @RequestMapping( method = RequestMethod.POST)
    public String createProduct(@RequestBody Products product, UriComponentsBuilder ucBuilder) {
		
    	//LocalDateTime now = LocalDateTime.now();
        /*System.out.println("Before : " + now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        System.out.println("After : " + formatDateTime);
        */
    	
    	//System.out.println(product.getIdStatus());
    	
    	product.setCreatedAt(new Date());
    	product.setUpdatedAt(new Date());
    	
    	Products proTemp = productService.save(product);

    	
    	//Al faltarle el codigo de idProducto lo busco cada uno de los q se insertaron y le inserto el objeto proTemp q ya tiene esa informacion
    	for ( RelationatedProduct rp: proTemp.getRelationatedProduct()){
    		RelationatedProduct pp = relationatedProductService.findOne(rp.getIdRelationatedProduct());
    		pp.setIdProduct(proTemp);    		
    		//Al salvarlo se agrega lo q faltaba 
    		relationatedProductService.save(pp);    		
    	}

    	//Obtengo el objeto nuevo
    	proTemp = productService.findOne(proTemp.getIdProduct());    	
    	
		
		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", proTemp.getIdProduct());
		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }


    @RequestMapping(method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Products product, UriComponentsBuilder ucBuilder){

    	//System.out.println(product.getIdProduct());
    	if (product.getRelationatedProduct() != null )
    		relationatedProductService.deleteByidProduct(product);

    	product.setUpdatedAt(new Date());
    	Products productRes = productService.save(product);

		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", productRes.getIdProduct());	    

		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<Void> findProduct(@RequestBody String product, @PathVariable("id") long id, UriComponentsBuilder ucBuilder) {
    public ResponseEntity<Object> findProduct(@PathVariable("id") String id, UriComponentsBuilder ucBuilder) {

		//poner el controlador de errores para cuando pase por aqui y no mande como id un numero
    	Long aa =  Long.parseLong(id);
		Products proTemp = productService.findOne(aa);
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
		this.productService.findOne(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}*/

}




