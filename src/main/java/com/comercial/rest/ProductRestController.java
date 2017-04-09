package com.comercial.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.model.Category;
import com.comercial.model.Products;
import com.comercial.model.QProducts;
import com.comercial.service.ProductService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;


//import javax.json.*;


@RestController
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	
	@RequestMapping(value = "/product/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countAll(){

	    Map toParse = new HashMap();
	    toParse.put("count", productService.count());	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
	
	@RequestMapping(value = "/product/count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countByParam(@RequestParam Map<String,String> requestParams) {

	    Map toParse = new HashMap();
	    toParse.put("count", productService.count(criteryConstructor(requestParams)));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
	
	
    @RequestMapping(value = "/product/list", method = RequestMethod.GET, produces = "application/json")
	//public @ResponseBody String product(@RequestParam(value ="page", defaultValue="") long page, @RequestParam(value ="perPage", defaultValue="") long perPage){@RequestParam Map<String,String> requestParams
    public @ResponseBody String product(@RequestParam Map<String,String> requestParams) {

		//System.out.println(requestParams.get("page") + "-" + requestParams.get("perPage"));

		Pageable pageable = new PageRequest(Integer.parseInt(requestParams.get("page"))-1, Integer.parseInt(requestParams.get("perPage")),new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "name")));		

		Page<Products> ll = productService.findAll(criteryConstructor(requestParams) ,pageable);
		System.out.println("Tamaño del Page:" + ll.getNumber());
		System.out.println("Tamaño de la lista:" + ll.getContent().size());
		
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
	
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public String createUser(@RequestBody Products product, UriComponentsBuilder ucBuilder) {
		
		Products proTemp = productService.save(product);
		
		Map toParse = new HashMap();
	    toParse.put("id", proTemp.getIdProduct());
		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }
    
    @RequestMapping(value = "/product/", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Products product, UriComponentsBuilder ucBuilder) {
		
		Products proTemp = productService.save(product);
		
		Map toParse = new HashMap();
	    toParse.put("id", proTemp.getIdProduct());

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
    
    
    private BooleanExpression criteryConstructor(Map<String,String> requestParams){
    	
    	
    	QProducts qpro = QProducts.products;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        System.out.println(e.getKey() + "=!" + e.getValue()+ "]!");
	        
	        BooleanExpression criterio = null;
	        if (e.getKey().equals("name")){
	        	criterio = qpro.products.name.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("description")){
	        	criterio = qpro.products.description.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("idCategory")){
	        	Category cat = new Category();
	    		cat.setIdCategory(Integer.parseInt(e.getValue().toString()));	        	
	        	criterio = qpro.products.idCategory.eq(cat);
	        }
	        
	        if (e.getKey().equals("code")){
	        	criterio = qpro.products.code.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }	        
	        
	        if (criterio != null){
	        	if (con == 0){
	        		criterioFinal = criterio;	
	        	}else{
	        		if (criterioFinal != null){
	        			criterioFinal = criterioFinal.and(criterio);
	        		}else{
	        			criterioFinal = criterio;
	        		}
	        	}
	        }
	        con++;
	    }
    	
		return criterioFinal;
    	
    }
    
    
    
 /*
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }*/
    


    	
    

}




