package com.comercial.service.interfaces;

import com.comercial.dto.ColorDto;
import com.comercial.dto.StatusDto;

public interface StatusServiceInterface extends Service{

	public StatusDto save(StatusDto entity);
	public StatusDto findById(Long id);

}