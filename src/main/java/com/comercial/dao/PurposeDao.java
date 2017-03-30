package com.comercial.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.comercial.model.Purpose;


@Repository
public class PurposeDao extends PrincipalDao {
	
	public List<Purpose> getList (long limit, long skip){

		TypedQuery<Purpose> consulta= em.createNamedQuery("Purpose.findAll", Purpose.class);
		
		if (limit> 0) {
			consulta.setMaxResults((int) limit);
		}
		
		if (skip> 0) {
			consulta.setFirstResult((int) skip);
		}		
		
		List<Purpose> lista= consulta.getResultList();

		return lista;

	}
}
