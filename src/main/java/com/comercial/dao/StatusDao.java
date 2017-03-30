package com.comercial.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.comercial.model.Status;


@Repository
public class StatusDao extends PrincipalDao {
	
	public List<Status> getList (long limit, long skip){

		TypedQuery<Status> consulta= em.createNamedQuery("Status.findAll", Status.class);
		
		if (limit> 0) {
			consulta.setMaxResults((int) limit);
		}
		
		if (skip> 0) {
			consulta.setFirstResult((int) skip);
		}		
		
		List<Status> lista= consulta.getResultList();

		return lista;

	}
}
