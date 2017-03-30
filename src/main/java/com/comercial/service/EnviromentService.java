package com.comercial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.dao.EnviromentDao;
import com.comercial.model.Enviroment;


@Service
public class EnviromentService {
	
	@Autowired
	EnviromentDao enviromentDao;

	@Transactional
	public List<Enviroment> getList(long limit, long skip) {
		
		List<Enviroment> lista= enviromentDao.getList(limit, skip);
		
		return lista;

	}

	
}
