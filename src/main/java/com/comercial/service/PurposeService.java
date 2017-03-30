package com.comercial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.dao.PurposeDao;
import com.comercial.model.Purpose;


@Service
public class PurposeService {
	
	@Autowired
	PurposeDao purposeDao;

	@Transactional
	public List<Purpose> getList(long limit, long skip) {
		
		List<Purpose> lista= purposeDao.getList(limit, skip);
		
		return lista;

	}

	
}
