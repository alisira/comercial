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

import com.comercial.model.Enviroment;
import com.comercial.model.QEnviroment;
import com.comercial.repository.EnviromentRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("EnviromentService")
@Transactional
public class EnviromentService {
	
	@Autowired
	private EnviromentRepository enviromentRepository;

	
	public  EnviromentRepository save(Enviroment entity) {
		// TODO Auto-generated method stub		
		return enviromentRepository;
	}

	public List<Enviroment> findAll(@RequestParam Map<String,String> requestParams) {		

		Sort sort = null;
		try {
		
			if (requestParams.get("page") != null && requestParams.get("perPage") != null){
				if (Integer.parseInt(requestParams.get("page"))-1 > -1 && Integer.parseInt(requestParams.get("perPage")) > 0 ){
					Pageable pageable = new PageRequest(Integer.parseInt(requestParams.get("page"))-1, Integer.parseInt(requestParams.get("perPage")),new Sort(Sort.Direction.ASC, "denomination"));
					return enviromentRepository.findAll(criteryConstructor(requestParams), pageable).getContent();
				}else{
					//sort = new Sort(Sort.Direction.ASC, "idEnviroment").and(new Sort(Sort.Direction.DESC, "denomination"));
					sort = new Sort(Sort.Direction.ASC, "denomination");
					return (List<Enviroment>) enviromentRepository.findAll(criteryConstructor(requestParams), sort);	
				}	
			}else{
				sort = new Sort(Sort.Direction.ASC, "denomination");
				return (List<Enviroment>) enviromentRepository.findAll(criteryConstructor(requestParams), sort);
			}
			
		}catch(NumberFormatException e) {
			sort = new Sort(Sort.Direction.ASC, "denomination");
			return (List<Enviroment>) enviromentRepository.findAll(criteryConstructor(requestParams), sort);
		}
		
	}
	
	public long count() {		
		return enviromentRepository.count();
	}
	
	private BooleanExpression criteryConstructor(Map<String,String> requestParams){
    	
    	QEnviroment qEnviroment = QEnviroment.enviroment;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());
	        
	        BooleanExpression criterio = null;
	        if (e.getKey().equals("denomination")){
	        	criterio = qEnviroment.enviroment.denomination.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("status")){	        		        	
	        	criterio = qEnviroment.status.eq((short)e.getValue());
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

