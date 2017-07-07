package com.comercial.service.interfaces;

import com.comercial.dto.ColorDto;

public interface ColorServiceInterface extends Service{

	public ColorDto save(ColorDto entity);
	public ColorDto findById(Long id);

}