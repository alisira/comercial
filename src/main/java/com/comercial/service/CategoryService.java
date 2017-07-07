package com.comercial.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.dto.CategoryDto;
import com.comercial.dto.ColorDto;
import com.comercial.model.Category;
import com.comercial.model.Color;
import com.comercial.model.QCategory;
import com.comercial.repository.CategoryRepository;
import com.comercial.service.interfaces.CategoryServiceInterface;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("CategoryService")
@Transactional
public class CategoryService  implements CategoryServiceInterface {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public  CategoryDto save(CategoryDto categoryDto) {
		//Falta el controlador de errores importante

		Category category = new Category();
		ServiceUtil.copyProperties(categoryDto, category);		

		if (category.getIdCategory() != null){
			category = categoryRepository.findOne(category.getIdCategory());
			if (category != null){
	        	String[] nullPropertyNames = ServiceUtil.getNullPropertyNames(categoryDto);
	            ServiceUtil.copyProperties(categoryDto, category, nullPropertyNames);
	        }else{
	        	ServiceUtil.copyProperties(categoryDto, category);
	        	category.setIdCategory(null);
	        }
		}

		Category categoryFinal = categoryRepository.save(category);
		ServiceUtil.copyProperties(categoryFinal, categoryDto);

		return categoryDto;

	}

	public String findAll(@RequestParam Map<String,String> requestParams) {
		
		/*Page<Category> resp = categoryRepository.findAll(criteryConstructor(requestParams),  ServiceUtil.pageConstructor(requestParams));		
		List<CategoryDto> listCategoryDto = new ArrayList<CategoryDto>();
		
		for ( Category category : resp.getContent() ) {
			
			CategoryDto categoryDtoTemp = new CategoryDto();
			ServiceUtil.copyProperties (category, categoryDtoTemp);			
			listCategoryDto.add(categoryDtoTemp);
			
		 }
		return listCategoryDto;*/
		
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
    	Page<Category> list = null;
		try {

			list = categoryRepository.findAll(criteryConstructor(requestParams),  ServiceUtil.pageConstructor(requestParams));			
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

	public BooleanExpression criteryConstructor(Map<String,String> requestParams){

    	QCategory qCategory = QCategory.category;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());

	        BooleanExpression criterio = null;
	        if (e.getKey().equals("denomination")){
	        	criterio = qCategory.category.denomination.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }

	        if (e.getKey().equals("status")){
	        	criterio = qCategory.status.eq((short)e.getValue());
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



	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public long count(@RequestParam Map<String,String> requestParams) {
		return categoryRepository.count(criteryConstructor(requestParams));
	}
	
	@Override
	public CategoryDto findById(Long id) {
		
		CategoryDto categoryDto = new CategoryDto();
		
		Category category = categoryRepository.findOne(id);
		
		if (category != null){
			ServiceUtil.copyProperties(category, categoryDto);
			return categoryDto;
		}else{
			return null;
		}
		
	}
}

