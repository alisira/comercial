package com.comercial.service;

import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.model.Category;
import com.comercial.model.QCategory;
import com.comercial.repository.CategoryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("CategoryService")
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	
	public  CategoryRepository save(Category entity) {
		return categoryRepository;
	}

	public Iterable<Category> findAll(@RequestParam Map<String,String> requestParams) {

		return categoryRepository.findAll(criteryConstructor(requestParams),  ServiceUtil.pageConstructor(requestParams));

	}

	public long count() {		
		return categoryRepository.count();
	}

	private BooleanExpression criteryConstructor(Map<String,String> requestParams){

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

}

