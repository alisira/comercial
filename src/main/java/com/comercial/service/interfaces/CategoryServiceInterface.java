package com.comercial.service.interfaces;

import com.comercial.dto.CategoryDto;
import com.comercial.model.Category;

public interface CategoryServiceInterface extends Service{
	
	public CategoryDto save(CategoryDto entity);
	public Category findById(Long id);

}