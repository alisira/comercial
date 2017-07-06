package com.comercial.service;

import java.beans.FeatureDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ServiceUtil extends BeanUtils{

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
	
    
    public static Pageable pageConstructor(Map<String,String> requestParams){
		
	    int page= 0;
	    int perPage= 0;
	    String order = null;
		//detect type of requestParams (array or plan text)
    	boolean typeParams= false;//true=array, false=plan text

	    for (Integer i=0; i < requestParams.size();i++){
	    	StringBuilder sb = new StringBuilder();
	    	sb.append(i);
	    	//System.out.println(requestParams.containsKey(sb.toString()));
	    	if (requestParams.containsKey(sb.toString())){
	    		typeParams = true;
	    	}
	    }

	    //true=array, false=plan text
	    if (typeParams){

			Iterator it = requestParams.entrySet().iterator();
	    	String[] xy =  new String[requestParams.size()];

	    	//insert ?0=p&1=a&10=P&11=a&12=g&13=e&14=%3D&15=1&16=0&17=%26 into a array
	    	while (it.hasNext()) {
				Map.Entry e = (Map.Entry)it.next();
		        xy[Integer.parseInt(e.getKey().toString())] = e.getValue().toString();
			}

	    	//convert xy into string page=1&perPage=10&code=a&conect=or&description=a&conect=or&name=a&
	    	String strQuery = "";
		    for (int i=0; i < xy.length;i++){
		    	strQuery  += xy[i];
		    }	    

		    String[] arrayParam =  strQuery.split("&");
	

		    for (int i=0; i < arrayParam.length;i++){

		    	String[] obj =  arrayParam[i].split("=");

		        if (obj[0].toString().equals("page")){
		        	page =  Integer.parseInt(obj[1].toString())-1;
		        }

		        if (obj[0].toString().equals("perPage")){
		        	perPage =  Integer.parseInt(obj[1].toString());
		        }
		        
		        if (obj[0].toString().equals("order")){
		        	order =  obj[1].toString();
		        }

		    }

		    if (page <= 0){
		    	page = 1;
		    }

		    if (perPage <= 0){
		    	perPage = 10;
		    }
		    
		  //return new PageRequest(page-1, perPage, new Sort(Sort.Direction.ASC, "denomination"));
		    if ( order != null){		    	
		    	return new PageRequest(page-1, perPage, new Sort(Sort.Direction.ASC, order));
		    }else{
		    	return new PageRequest(page-1, perPage);	
		    }
		    
	    }else{

	    	if (requestParams.get("page") != null){
	    		if (requestParams.get("page").matches("^[0-9]+$")) {
	    			if (Integer.parseInt(requestParams.get("page")) <= 0){
	    				page = 1;
	    			}else{
	    				page = Integer.parseInt(requestParams.get("page")); 
	    			}

	    			if (requestParams.get("perPage") != null){
	    	    		if (requestParams.get("perPage").matches("^[0-9]+$") ){
	    		    		if (Integer.parseInt(requestParams.get("perPage")) <= 0){
	    		    			perPage = 10;
	    		    		}else{
	    		    			perPage = Integer.parseInt(requestParams.get("perPage")); 
	    				    }
	    		    	}
	    	    	}
	    		}
	    	}

	    	if (perPage == 0 || page == 0 ){
	    		return null;
	    	}else{	    		
		    	if (requestParams.get("order") != null){			    	
			    	return new PageRequest(page-1, perPage,new Sort(Sort.Direction.ASC, requestParams.get("order")));
			    }else{
			    	return new PageRequest(page-1, perPage);
			    }
	    	}
	    }
	}
	
}
