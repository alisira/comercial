package com.comercial.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.comercial.model.Enviroment;


@Repository
public class EnviromentDao extends PrincipalDao {
	
	public List<Enviroment> getList (long limit, long skip){

		TypedQuery<Enviroment> consulta= em.createNamedQuery("Enviroment.findAll", Enviroment.class);
		
		if (limit> 0) {
			consulta.setMaxResults((int) limit);
		}
		
		if (skip> 0) {
			consulta.setFirstResult((int) skip);
		}		
		
		List<Enviroment> lista= consulta.getResultList();

		return lista;

	}
}
