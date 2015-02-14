package br.com.startup.fucapi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_PROJETO");
	
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
	
}
