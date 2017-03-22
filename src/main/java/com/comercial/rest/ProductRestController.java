package com.comercial.rest;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.model.Products;
import com.comercial.model.Purpose;
import com.comercial.service.ProductService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solidfire.gson.Gson;
import com.solidfire.gson.GsonBuilder;
import com.solidfire.gson.JsonElement;
import com.solidfire.gson.JsonObject;
import com.solidfire.gson.JsonSerializationContext;
import com.solidfire.gson.JsonSerializer;

//import pe.joedayz.modelo.User;
//import pe.joedayz.service.UserService;

//import pe.joedayz.service.UserService;
//import web.domain.User;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;





@RestController
public class ProductRestController {


	/*@Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 */
	
	@Autowired
	ProductService productService;
	
    
    //-------------------Retrieve All Users--------------------------------------------------------
	
    @RequestMapping(value = "/product2/", method = RequestMethod.GET)
    public ResponseEntity<List<Products>> listAllUsers() {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("FL_PU");
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Products> consultaAlumnos= em.createNamedQuery("Products.findAll", Products.class);
    	//consultaAlumnos.setParameter("nombre", "miguel");
    	List<Products> lista= consultaAlumnos.getResultList();

    	System.out.println("*************Alumnos*********");
    	
    	
    	
    	for (Products a :lista) {

    		//System.out.println(a.getName()+"," );
    		System.out.println(a.getName()+"," +a.getIdPurpose().getDenomination());
    		
    		
    		TypedQuery<Purpose> pp = em.createNamedQuery("Purpose.findByIdPurpose", Purpose.class);
    		pp.setParameter("idPurpose", a.getIdProduct());
    		//Purpose pp2 =  pp.getSingleResult();
    		int pp3 =  pp.getFirstResult();
    		

    	}
    	
    	em.close();
    	
    	System.out.println("termino");
    	
    	
        /*List<Products> products = Products.findAll();
        if(products.isEmpty()){
            return new ResponseEntity<List<Products>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }*/
    	
        return new ResponseEntity<List<Products>>(lista, HttpStatus.OK);
    }
	
	
    @RequestMapping(value = "/product/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String registerNewUsert(){
    	

    	List<Products> lista = productService.getList();


    	for (Products a :lista) {

    		//System.out.println(a.getName()+"," );
    		//System.out.println(a.getName()+"," +a.getIdPurpose().getDenomination());

    	}



    	/*GsonBuilder gsonBuilder = new GsonBuilder();
    	Gson gsonPurpose = gsonBuilder.registerTypeAdapter(lista.getClass(), new AutoAdapterList()).create();
    	String jsonPurpose = gsonPurpose.toJson(lista);
    	-*/
    	
    	

    	
    	
    
    	
    	
    	
    	
        
    	/*
        Student a = new Student("Alice", "Apple St");
        Student b = new Student("Bob", "Banana St");
        Student c = new Student("Carol", "Grape St");
        Student d = new Student("Mallory", "Mango St");

        List<Student> students = new ArrayList<Student>();
        students.add(a);
        students.add(b);
        students.add(c);
        students.add(d);

        Gson gson = new Gson();
        String jsonStudents = gson.toJson(students);
        System.out.println("jsonStudents = " + jsonStudents);
    	*/
        
    	
    	
        
    	/*Gson gson = new Gson();
        String jsonStudents = gson.toJson(lista.toArray());
        System.out.println("jsonStudents = " + jsonStudents);
        */
    	
    	/*Products p1 = new Products();
    	p1.setCode("tt");
    	p1.setDescription("d1");
    	
    	Products p2 = new Products();
    	p2.setCode("aa");
    	p2.setDescription("aa");
    	*/
    	
    	Products p1 = new Products();
    	p1 = lista.get(0);
    	
    	Products p2 = new Products();
    	p2 = lista.get(1);
    	
    	
    	Products p3 = new Products();
    	p3 = lista.get(4);
    	
    	
    	
    	List<Products> students = new ArrayList<Products>();
        students.add(p1);
        students.add(p2);
        students.add(p3);
        
        /*Gson gson = new Gson();
        String jsonStudents = gson.toJson(students);
        System.out.println("jsonStudents = " + jsonStudents);
        */
        
        //Purpose aa =  lista.get(0).getIdPurpose();
        //aa =  lista.get(2).getIdPurpose();
        
        
        
    	ObjectMapper mapper = new ObjectMapper();

		//For testing
		//User user = createDummyUser();
    	String jsonInString = null;
		try {

			//Convert object to JSON string
			jsonInString = mapper.writeValueAsString(lista);
			//System.out.println(jsonInString);

			//Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
			//System.out.println(jsonInString);


		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        
        
        
        
        
    	
    	// Serialization
    	
    	
    	/*json = gson.toJson(lista);    	
    	System.out.println(json);
    	
    	
    	json = gson.toJson(lista.get(0));    	
    	System.out.println(json);
    	*/
    	
    	
    	//BagOfPrimitives obj = new BagOfPrimitives();
    	//Gson gson = new Gson();
    	//String json = gson.toJson(lista.get(0).getIdPurpose());

    	
    	
		return jsonInString ;
    	//return "Hola";
}  
	

    @RequestMapping(value = "/product3/", method = RequestMethod.GET)
	public @ResponseBody String registerNewUsert3(){
		
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("FL_PU");
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Products> consultaAlumnos= em.createNamedQuery("Products.findAll", Products.class);
    	//consultaAlumnos.setParameter("nombre", "miguel");
    	List<Products> lista= consultaAlumnos.getResultList();

        
    	/*for (Products a :lista) {

    		//System.out.println(a.getName()+"," );
    		System.out.println(a.getName()+"," +a.getIdPurpose().getDenomination());
    		
    		
    		TypedQuery<Purpose> pp = em.createNamedQuery("Purpose.findByIdPurpose", Purpose.class);
    		pp.setParameter("idPurpose", a.getIdProduct());
    		//Purpose pp2 =  pp.getSingleResult();
    		int pp3 =  pp.getFirstResult();
    		
    		

    	}
    	
    	System.out.println(lista.get(0).getIdPurpose().getDenomination());
    	em.close();*/
    	
    	
    	
    	// Serialization
    	/*BagOfPrimitives obj = new BagOfPrimitives();
    	Gson gson = new Gson();
    	String json = gson.toJson(obj);*/
    	
    	//System.out.println(json);
    	
    	
    	
    	List<Products> lista = productService.getList();
    	
    	
    	
    	for (Products a :lista) {

    		//System.out.println(a.getName()+"," );
    		//System.out.println(a.getName()+"," +a.getIdPurpose().getDenomination());
    		
    	}
    	
    	
    	
    	Purpose pp = new Purpose();
    			pp.setDenomination("Ali");
    			pp.setIdPurpose(1);
    			
    			
    			Purpose pp2 = new Purpose();
    			
    			pp2 =  lista.get(0).getIdPurpose();
    			
    			System.out.println(pp2.getClass());//com.comercial.model.Purpose_$$_jvst278_d
    			
    	
    	
    	GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gsonPurpose = gsonBuilder.registerTypeAdapter(pp2.getClass(), new AutoAdapterPurpose()).create();
        String jsonPurpose = gsonPurpose.toJson(pp2);
    	
        //System.out.println(jsonPurpose);
    	
    	
    	
    	// Serialization
    	
    	
    	/*json = gson.toJson(lista);    	
    	System.out.println(json);
    	
    	
    	json = gson.toJson(lista.get(0));    	
    	System.out.println(json);
    	*/
    	
    	
    	//BagOfPrimitives obj = new BagOfPrimitives();
    	//Gson gson = new Gson();
    	//String json = gson.toJson(lista.get(0).getIdPurpose());
    	
    	
    	
        
    	
    	
    	
    	
    	GsonBuilder gsonBuilder2 = new GsonBuilder();
        Gson gson = gsonBuilder2.registerTypeAdapter(Products.class, new AutoAdapter(jsonPurpose)).create();
        String json = gson.toJson(lista.get(0));
    	
    	
    	
    	//json = gson.toJson(lista.get(0).getIdPurpose());    	
    	System.out.println(json);
    	
    	
    	
    	 
    	 String text2 = json.replaceAll("\\\\", "").replaceAll("\"\\{", "\\{").replaceAll("\\}\"\\}", "\\}\\}");
    	
    	
    	return text2 ;
    	//return "Hola";
}    
    
    
    public class AutoAdapterList implements JsonSerializer<List> {

		public JsonElement serialize(List src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject jsonObject = new JsonObject();
    		//jsonObject.addProperty("id", src.toArray());
    		
    		return jsonObject;
		}

		
    }  
    
 
    public class AutoAdapterPurpose implements JsonSerializer<Purpose> {

    	public JsonElement serialize(Purpose src, Type typeOfSrc, JsonSerializationContext context) {    	
    		JsonObject jsonObject = new JsonObject();
    		jsonObject.addProperty("id", src.getIdPurpose());
    		jsonObject.addProperty("denomination", src.getDenomination());
    		return jsonObject;
    	}

		
    }
    
public class AutoAdapter implements JsonSerializer<Products> {
    	
    	Products product;
    	String purpose;
    	
    	AutoAdapter(String jsonPurpose){
    		this.purpose =  jsonPurpose;
    	}

    	public JsonElement serialize(Products src, Type typeOfSrc, JsonSerializationContext context) {
    		JsonObject jsonObject = new JsonObject();
    		jsonObject.addProperty("code", src.getCode());
    		jsonObject.addProperty("description", src.getDescription());    		
    		jsonObject.addProperty("purpose", this.purpose);
    		return jsonObject;
    	}
    }
    

class Student {
	  private String nombre;
	  private String dir;
	  
	  Student(String nombre,String dir ){
		  this.nombre = nombre;
		  this.dir = dir;
	  }
	  
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	  
	  
	  
	}

    
    class BagOfPrimitives {
  	  private int value1 = 1;
  	  private String value2 = "abc";
  	  private transient int value3 = 3;
  	  BagOfPrimitives() {
  	    // no-args constructor
  	  }
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

