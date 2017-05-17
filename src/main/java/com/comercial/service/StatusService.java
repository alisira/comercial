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

import com.comercial.model.Status;
import com.comercial.model.QStatus;
import com.comercial.repository.StatusRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("StatusService")
@Transactional
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;


	public  StatusRepository save(Status entity) {
		return statusRepository;
	}

	public List<Status> findAll(@RequestParam Map<String,String> requestParams) {

		Sort sort = null;
		try {

			if (requestParams.get("page") != null && requestParams.get("perPage") != null){
				if (Integer.parseInt(requestParams.get("page"))-1 > -1 && Integer.parseInt(requestParams.get("perPage")) > 0 ){
					Pageable pageable = new PageRequest(Integer.parseInt(requestParams.get("page"))-1, Integer.parseInt(requestParams.get("perPage")),new Sort(Sort.Direction.ASC, "denomination"));
					return statusRepository.findAll(criteryConstructor(requestParams), pageable).getContent();
				}else{
					//sort = new Sort(Sort.Direction.ASC, "idStatus").and(new Sort(Sort.Direction.DESC, "denomination"));
					sort = new Sort(Sort.Direction.ASC, "denomination");
					return (List<Status>) statusRepository.findAll(criteryConstructor(requestParams), sort);	
				}
			}else{
				sort = new Sort(Sort.Direction.ASC, "denomination");
				return (List<Status>) statusRepository.findAll(criteryConstructor(requestParams), sort);
			}

		}catch(NumberFormatException e) {
			sort = new Sort(Sort.Direction.ASC, "denomination");
			return (List<Status>) statusRepository.findAll(criteryConstructor(requestParams), sort);
		}

	}

	public long count() {
		return statusRepository.count();
	}

	private BooleanExpression criteryConstructor(Map<String,String> requestParams){

    	QStatus qStatus = QStatus.status;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());

	        BooleanExpression criterio = null;
	        if (e.getKey().equals("denomination")){
	        	criterio = qStatus.status.denomination.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("table_")){
	        	criterio = qStatus.status.table.likeIgnoreCase("%" + (String)e.getValue() + "%");
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

