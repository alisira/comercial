package com.comercial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.dao.StatusDao;
import com.comercial.model.Status;


@Service
public class StatusService {
	
	@Autowired
	StatusDao statusDao;

	@Transactional
	public List<Status> getList(long limit, long skip) {
		
		List<Status> lista= statusDao.getList(limit, skip);
		
		return lista;

	}

	
}
