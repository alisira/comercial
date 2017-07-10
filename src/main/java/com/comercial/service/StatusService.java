package com.comercial.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.model.Status;
import com.comercial.dto.StatusDto;
import com.comercial.model.QStatus;
import com.comercial.repository.StatusRepository;
import com.comercial.service.interfaces.StatusServiceInterface;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("StatusService")
@Transactional
public class StatusService implements StatusServiceInterface {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public StatusDto findById(Long id) {
		
		StatusDto statusDto = new StatusDto();

		Status status = statusRepository.findOne(id);

		if (status != null){
			ServiceUtil.copyProperties(status, statusDto);
			return statusDto;
		}else{
			return null;
		}
	}
	
	@Override
	public  StatusDto save(StatusDto statusDto) {
		//Falta el controlador de errores importante

		Status status = new Status();
		ServiceUtil.copyProperties(statusDto, status);		

		if (status.getIdStatus() != null){
			status = statusRepository.findOne(status.getIdStatus());
			if (status != null){
	        	String[] nullPropertyNames = ServiceUtil.getNullPropertyNames(statusDto);
	            ServiceUtil.copyProperties(statusDto, status, nullPropertyNames);
	        }else{
	        	ServiceUtil.copyProperties(statusDto, status);
	        	status.setIdStatus(null);
	        }
		}

		Status statusFinal = statusRepository.save(status);
		ServiceUtil.copyProperties(statusFinal, statusDto);

		return statusDto;

	}

	public String findAll(@RequestParam Map<String,String> requestParams) {

		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
    	Page<Status> list = null;
		try {

			list = statusRepository.findAll(criteryConstructor(requestParams),  ServiceUtil.pageConstructor(requestParams));			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonInString;
		
	}

	public long count() {
		return statusRepository.count();
	}

	public BooleanExpression criteryConstructor(Map<String,String> requestParams){

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
	
	public void deleteAll(){
		statusRepository.deleteAll();
	}

	@Override
	public long count(Map<String, String> requestParams) {
		return statusRepository.count(criteryConstructor(requestParams));		
	}	

}

