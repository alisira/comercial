package com.comercial.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.comercial.model.Color;


@Repository
public class ColorDao extends PrincipalDao {
	
	public List<Color> getList (long limit, long skip){

		TypedQuery<Color> consulta= em.createNamedQuery("Color.findAll", Color.class);
		
		if (limit> 0) {
			consulta.setMaxResults((int) limit);
		}
		
		if (skip> 0) {
			consulta.setFirstResult((int) skip);
		}		
		
		List<Color> lista= consulta.getResultList();

		return lista;

	}
}
