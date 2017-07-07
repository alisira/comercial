package com.comercial.service;

import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

		//Pageable paged = ServiceUtil.pageConstructor(requestParams);
		
		return colorRepository.findAll(criteryConstructor(requestParams),  ServiceUtil.pageConstructor(requestParams));
		
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
	        	criterio = qColor.idStatus.eq((short)e.getValue());
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
	
}

