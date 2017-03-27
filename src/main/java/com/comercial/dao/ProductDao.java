package com.comercial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.comercial.model.Products;

@Repository
public class ProductDao  extends PrincipalDao {
	
	public List<Products> getList (long limit, long skip){

		TypedQuery<Products> consulta= em.createNamedQuery("Products.findAll", Products.class);
		
		if (limit> 0) {
			consulta.setMaxResults((int) limit);
		}
		
		if (skip> 0) {
			consulta.setFirstResult((int) skip);
		}		
		
		List<Products> lista= consulta.getResultList();

		return lista;

	}
}
