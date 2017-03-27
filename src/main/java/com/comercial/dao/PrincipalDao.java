package com.comercial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Clase de utilidad para conseguir la sesión de Hibernate.
 * La sesión es única por thread.
 * Pueden existir varios ficheros de configuración.
 * Al menos siempre existirá la configuración por defecto sacada del fichero "hibernate.cfg.xml".
 * 
 * @author Autentia
 */
public class PrincipalDao {
    
    static final EntityManagerFactory emf;
    static final EntityManager em;

	static {
        try {
    		
        	emf = Persistence.createEntityManagerFactory("FL_PU");
    		em = emf.createEntityManager();
    		System.out.println("Prueba en principaldao");
            
        } catch (Throwable e) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }

    }
    
    
}