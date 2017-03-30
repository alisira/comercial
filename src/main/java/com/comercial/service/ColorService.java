package com.comercial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.dao.ColorDao;
import com.comercial.model.Color;


@Service
public class ColorService {
	
	@Autowired
	ColorDao colorDao;

	@Transactional
	public List<Color> getList(long limit, long skip) {
		
		List<Color> lista= colorDao.getList(limit, skip);
		
		return lista;

	}

	
}
