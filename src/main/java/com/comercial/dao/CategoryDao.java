package com.comercial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.comercial.model.Category;
import com.comercial.model.Products;

@Repository
public class CategoryDao extends PrincipalDao {
	
	public List<Category> getList (){
		
		TypedQuery<Category> consulta= em.createNamedQuery("Category.findAll", Category.class);
		List<Category> lista= consulta.getResultList();

		return lista;

	}
}
