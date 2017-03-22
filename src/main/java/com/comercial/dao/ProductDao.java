package com.comercial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.comercial.model.Products;

@Repository
public class ProductDao {
	
	public List<Products> getList (){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FL_PU");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Products> consulta= em.createNamedQuery("Products.findAll", Products.class);

		List<Products> lista= consulta.getResultList();

		return lista;

	}
}
