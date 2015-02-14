package br.com.startup.fucapi.model;

import javax.persistence.EntityManager;

import br.com.startup.fucapi.util.JPAUtil;

public class OperacaoEntityManager {

	private EntityManager entityManager;

	public OperacaoEntityManager() {
		entityManager = new JPAUtil().getEntityManager();
	}

	public void beginTransaction(){
		entityManager.getTransaction().begin();
	}

	public void commit(){
		entityManager.getTransaction().commit();
	}


	public void close(){
		entityManager.close();
	}

	public void rollBack(){
		entityManager.getTransaction().rollback();
	}

	public EntityManager getEntityManager(){
		return entityManager;
	}
}
