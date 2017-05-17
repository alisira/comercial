package com.comercial.service;

import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.model.Color;
import com.comercial.model.QColor;
import com.comercial.repository.ColorRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("ColorService")
@Transactional
public class ColorService {
	
	@Autowired
	private ColorRepository colorRepository;

	
	public  Color save(Color entity) {
		//Falta el controlador de errores importante 

		Color entityFinal = null;

		if (entity.getIdColor() != null){
			Color color = colorRepository.findOne(entity.getIdColor());
			if (color != null){
	        	String[] nullPropertyNames = ServiceUtil.getNullPropertyNames(entity);
	            ServiceUtil.copyProperties(entity, color, nullPropertyNames);
	            entityFinal =  color;
	        }else{
	        	entityFinal =  entity;
	        }

		}else{
			entityFinal =  entity;	
		}

		return colorRepository.save(entityFinal);

	}

	public Iterable<Color> findAll(@RequestParam Map<String,String> requestParams) {

		Pageable paged = pageConstructor(requestParams);

		if (paged == null ){
			return colorRepository.findAll(criteryConstructor(requestParams), QColor.color.denomination.asc());
		}else{
			return colorRepository.findAll(criteryConstructor(requestParams), paged);
		}
	}

	public long count() {
		return colorRepository.count();
	}

	public long count(@RequestParam Map<String,String> requestParams) {
		return colorRepository.count(criteryConstructor(requestParams));
	}

	private BooleanExpression criteryConstructor(Map<String,String> requestParams){

    	QColor qColor = QColor.color;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());
	        
	        BooleanExpression criterio = null;
	        
	        if (e.getKey().equals("idColor")){
	        	criterio = qColor.idColor.eq(Long.parseLong(e.getValue().toString()));
	        }
	        
	        if (e.getKey().equals("denomination")){
	        	criterio = qColor.color.denomination.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("status")){
	        	criterio = qColor.status.eq((short)e.getValue());
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
	
	private Pageable pageConstructor(Map<String,String> requestParams){
		
	    int page= 0;
	    int perPage= 0;
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

		    }

		    if (page <= 0){
		    	page = 1;
		    }

		    if (perPage <= 0){
		    	perPage = 10;
		    }

		    return new PageRequest(page-1, perPage, new Sort(Sort.Direction.ASC, "denomination"));
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
	    		return new PageRequest(page-1, perPage,new Sort(Sort.Direction.ASC, "denomination"));
	    	}

	    }

	}

}

