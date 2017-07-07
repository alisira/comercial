package com.comercial.service.interfaces;

import com.comercial.dto.CategoryDto;

public interface CategoryServiceInterface extends Service{

	public CategoryDto save(CategoryDto entity);
	public CategoryDto findById(Long id);

}