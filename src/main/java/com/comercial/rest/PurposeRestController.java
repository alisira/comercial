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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.comercial.model.Purpose;
import com.comercial.service.PurposeService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//import javax.json.*;


@RestController
public class PurposeRestController {


	@Autowired
	PurposeService purposeService;	
	
	@RequestMapping(value = "/purpose/count/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  String count(){

		List<Purpose> lista = purposeService.getList(0, 0);
	    
	    Map toParse = new HashMap();
	    toParse.put("count", lista.size());
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();
		
	}	
	
	
    @RequestMapping(value = "/purpose/", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String purpose(@RequestBody String param){

    	long limit = 0;
		long skip = 0;

		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(param);
			
			limit =  (long) json.get("limit");
			skip =  (long) json.get("skip");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
    	//System.out.println(skip + "-" + limit);
    	
    	List<Purpose> lista = purposeService.getList(limit, skip);
    	
    	
    	int c =0;
    	Map toParse1 = new HashMap();
    	for (Purpose a :lista) {

    		//System.out.println(a.getName()+"," );
    		Map toParse = new HashMap();
		    toParse.put("denomination", a.getDenomination());
		    toParse.put("idPurpose", a.getIdPurpose());
			
		    
		    toParse1.put("reg"+c, toParse);
    		c++;

    	}
    	JSONObject jsonObject = new JSONObject(toParse1);
    	
    	
    	//System.out.println(jsonObject);
    	
        
    	ObjectMapper mapper = new ObjectMapper();


    	String jsonInString = null;
		try {
			//System.out.println(lista.get(0));
			

			//Convert object to JSON string
			//jsonInString = mapper.writeValueAsString(jsonObject);
			//System.out.println(jsonInString);

			//Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
			//System.out.println(jsonInString);


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

