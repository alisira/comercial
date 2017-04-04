package com.comercial.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.model.Products;
import com.comercial.service.ProductService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//import javax.json.*;


@RestController
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/product/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String count(){

		long total =  productService.count();
	    
	    Map toParse = new HashMap();
	    toParse.put("count", total);	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();
		
	}	
	
	
    @RequestMapping(value = "/product/{page}/{per_page}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String product(@PathVariable("page") long page, @PathVariable("per_page") long perPage){

		System.out.println(page + "-" +  perPage);
		
		Pageable pageable = new PageRequest((int)page-1, (int)perPage,new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "name")));
		//Page list = productService.pagination(pageable).getContent();
		
		//List list2 = list.getContent();
		
		
		
		//*Asi Creo los productos que puedo mandar sin los id foraneos
		/*List<Products> proTemp = new ArrayList<Products>();
		for(int i=0; i< a.getContent().size();i++){
			Products aa = new  Products ((Products) a.getContent().get(i));			
			proTemp.add(aa);
		}*/
        
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {
			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productService.pagination(pageable).getContent());

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
    public ResponseEntity<Void> createUser(@RequestBody Products product, UriComponentsBuilder ucBuilder) {
        
    	
    	long limit = 0;
		long skip = 0;

		JSONParser parser = new JSONParser();
		JSONObject json = null;
		
		
		
		
		/*try {
			//json = (JSONObject) parser.parse(product);
			
			//limit =  (long) json.get("limit");
			//skip =  (long) json.get("skip");
			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	System.out.println(json);
    	*/
 
        /*if (productService.saveProduct(product)) {
            System.out.println("A product with name " + product.getDescription() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        boolean resp = productService.saveProduct(product);
        
        System.out.println(resp);
        */
		/*System.out.println(product);
		System.out.println(product.getCode());
		System.out.println(product.getDescription());
		System.out.println(product.getFinish());
		System.out.println(product.getItemBox());*/
		System.out.println(product.getIdColor().getIdColor());
		System.out.println(product.getIdEnviroment().getIdEnviroment());
		System.out.println(product.getIdPurpose());
		System.out.println(product.getIdCategory());
		
		
		Products proTemp = productService.saveProducts(product);
		
		System.out.println(proTemp);
		
		
 
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getIdProduct()).toUri());
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(1).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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

