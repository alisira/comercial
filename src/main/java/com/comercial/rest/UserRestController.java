package com.comercial.rest;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

//import pe.joedayz.service.UserService;
//import web.domain.User;



@RestController
public class UserRestController {

	  /*@Autowired
	    UserService userService;  //Service which will do all data retrieval/manipulation work
	    */
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		//System.out.println("user:" + user.getName());		
		//System.out.println("user2:" + user.toString());
		
		
		/*Por motivos de seguridad No devolver el objeto user y armar un objeto personalizado solo con los datos del usuario que se requieren  
		
		String a = "{\"resp\":\"ok\"}";		
		return new ResponseEntity<String>(a, HttpStatus.OK);
		*/
		
		return user;
	}
	
	
	    //-------------------Create a User--------------------------------------------------------
	     
	    @RequestMapping(value = "/user_permission/", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	    public ResponseEntity<String> userPermission(    UriComponentsBuilder ucBuilder) {
	        //System.out.println("Id de Usuario" + user.getId());
	 
	        String a = "{\"nDados\":2,\"redPlayer\":\"ghh\",\"bluePlayer\":null,\"yellowPlayer\":\"ghgh\",\"greenPlayer\":null}";
	        a = "{\"resp\":\"ok\"}";
	        
	        a = "{\"permisos\":[{\"desc\":\"Admin Producto\", \"url\":\"admin_product\"},"
	        		+ "{\"desc\":\"Admin Color\", \"url\":\"admin_color\"},"
	        		+ "{\"desc\":\"Admin Oferta\", \"url\": \"admin_offer\"},"
	        		+ "{\"desc\":\"Admin Descuento\", \"url\": \"admin_discount\"},"
	        		+ "{\"desc\":\"Admin Categoria\", \"url\": \"admin_category\"},"
	        		+ "{\"desc\":\"Admin Ambiente\", \"url\": \"admin_enviroment\"},"           
	        		+ "{\"desc\":\"Admin User\", \"url\": \"admin_user\"},"
	        		+ "{\"desc\":\"Admin Orden\", \"url\": \"admin_order\"},"
	        		+ "{\"desc\":\"Admin Store\", \"url\": \"admin_store\"},"
	        		+ "{\"desc\":\"Admin Costo de Envio\", \"url\": \"admin_ship_cost\"},"
	        		+ "{\"desc\":\"Reportes\", \"url\": \"admin_report\"}]}";
	        
	        //System.out.println(a);
	        
	        
	        //a = "{\"resp\":\"ok\"}";
	        
	        return new ResponseEntity<String>(a, HttpStatus.OK);
	    }

}
