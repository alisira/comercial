package com.comercial.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.dto.ColorDto;
import com.comercial.model.Color;
import com.comercial.model.QColor;
import com.comercial.repository.ColorRepository;
import com.comercial.service.interfaces.ColorServiceInterface;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("ColorService")
@Transactional
public class ColorService implements ColorServiceInterface{

	@Autowired
	private ColorRepository colorRepository;

	@Override
	public  ColorDto save(ColorDto colorDto) {
		//Falta el controlador de errores importante

		Color color = new Color();
		ServiceUtil.copyProperties(colorDto, color);		

		if (color.getIdColor() != null){
			color = colorRepository.findOne(color.getIdColor());
			if (color != null){
	        	String[] nullPropertyNames = ServiceUtil.getNullPropertyNames(colorDto);
	            ServiceUtil.copyProperties(colorDto, color, nullPropertyNames);
	        }else{
	        	ServiceUtil.copyProperties(colorDto, color);
	        	color.setIdColor(null);
	        }
		}

		Color colorFinal = colorRepository.save(color);
		ServiceUtil.copyProperties(colorFinal, colorDto);

		return colorDto;

	}

	@Override
	public ColorDto findById(Long id) {

		ColorDto colorDto = new ColorDto();

		Color color = colorRepository.findOne(id);

		if (color != null){
			ServiceUtil.copyProperties(color, colorDto);
			return colorDto;
		}else{
			return null;
		}

	}

	@Override
	public String findAll(@RequestParam Map<String,String> requestParams) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
    	Page<Color> list = null;
		try {

			list = colorRepository.findAll(criteryConstructor(requestParams),  ServiceUtil.pageConstructor(requestParams));			
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

	@Override
	public long count() {
		return colorRepository.count();
	}

	@Override
	public long count(@RequestParam Map<String,String> requestParams) {
		return colorRepository.count(criteryConstructor(requestParams));
	}

	@Override
	public BooleanExpression criteryConstructor(Map<String,String> requestParams){

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

