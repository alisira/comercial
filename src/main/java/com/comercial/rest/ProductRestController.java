package com.comercial.rest;

import java.io.IOException;
import java.util.HashMap;
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
	public @ResponseBody String count(){
		
		
		/*Pageable pageable = new PageRequest(0, 20,new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "name")));
		Products pp = new Products();
		pp.setName("FACHALETA BARLETT NATUR 34X60");
		//List<Products> ll = productService.findAllByCustomProduct(pp, pageable);
		//System.out.println("Tamaños" + ll.size());
		
		Category cat = new Category();
		cat.setIdCategory(2);		
		QProducts qpro = QProducts.products;		
		BooleanExpression creti1 = qpro.products.name.eq("FACHALETA BARLETT NATUR 34X60");
		BooleanExpression creti2 = qpro.products.description.eq("FACHALETA BARLETT NATUR 34X60");
		BooleanExpression creti3 = qpro.products.idCategory.eq(cat);
		Page<Products> ll = productService.findAll(creti1.and(creti2).and(creti3),pageable);
		System.out.println("Tamaño" + ll.getNumber());
		
		System.out.println(ll.getContent().size());
		
		ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {
			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( ll.getContent());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
		
	    
	    Map toParse = new HashMap();
	    toParse.put("count", productService.count());	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();
		
	}	
	
	
    @RequestMapping(value = "/product/list", method = RequestMethod.GET, produces = "application/json")
	//public @ResponseBody String product(@RequestParam(value ="page", defaultValue="") long page, @RequestParam(value ="perPage", defaultValue="") long perPage){@RequestParam Map<String,String> requestParams
    public @ResponseBody String product(@RequestParam Map<String,String> requestParams) {

		//System.out.println(requestParams.get("page") + "-" + requestParams.get("perPage"));
		
		Pageable pageable = new PageRequest(Integer.parseInt(requestParams.get("page"))-1, Integer.parseInt(requestParams.get("perPage")),new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "name")));
		//Page list = productService.pagination(pageable).getContent();
		//List list2 = list.getContent();
		//*Asi Creo los productos que puedo mandar sin los id foraneos
		/*List<Products> proTemp = new ArrayList<Products>();
		for(int i=0; i< a.getContent().size();i++){
			Products aa = new  Products ((Products) a.getContent().get(i));			
			proTemp.add(aa);
		}*/
		
		/*Products pp = new Products();
		pp.setName("FACHALETA BARLETT NATUR 34X60");
		List<Products> ll = productService.findAllByCustomProduct(pp, pageable);
		System.out.println("Tamaños" + ll.size());
		*/
		
		
		
		
		
		
        
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = null;
		try {
			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( productService.findAll(pageable).getContent());

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




