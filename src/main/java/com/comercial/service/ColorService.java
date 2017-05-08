package com.comercial.service;

import java.util.Iterator;
import java.util.List;
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

	
	public  ColorRepository save(Color entity) {
		// TODO Auto-generated method stub		
		return colorRepository;
	}

	public List<Color> findAll(@RequestParam Map<String,String> requestParams) {		

		Sort sort = null;
		try {
		
			if (requestParams.get("page") != null && requestParams.get("perPage") != null){
				if (Integer.parseInt(requestParams.get("page"))-1 > -1 && Integer.parseInt(requestParams.get("perPage")) > 0 ){
					Pageable pageable = new PageRequest(Integer.parseInt(requestParams.get("page"))-1, Integer.parseInt(requestParams.get("perPage")),new Sort(Sort.Direction.ASC, "denomination"));
					return colorRepository.findAll(criteryConstructor(requestParams), pageable).getContent();
				}else{
					//sort = new Sort(Sort.Direction.ASC, "idColor").and(new Sort(Sort.Direction.DESC, "denomination"));
					sort = new Sort(Sort.Direction.ASC, "denomination");
					return (List<Color>) colorRepository.findAll(criteryConstructor(requestParams), sort);	
				}	
			}else{
				sort = new Sort(Sort.Direction.ASC, "denomination");
				return (List<Color>) colorRepository.findAll(criteryConstructor(requestParams), sort);
			}
			
		}catch(NumberFormatException e) {
			sort = new Sort(Sort.Direction.ASC, "denomination");
			return (List<Color>) colorRepository.findAll(criteryConstructor(requestParams), sort);
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

}

