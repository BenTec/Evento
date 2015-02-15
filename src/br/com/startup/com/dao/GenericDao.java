package br.com.startup.com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.startup.fucapi.util.JPAUtil;

public abstract class GenericDao<T> implements IGenericDao<T>  {

	private EntityManager entityManager;
	private Class<T> persistencias;

	@SuppressWarnings("unchecked")
	public GenericDao(){
		ParameterizedType type =(ParameterizedType) getClass().getGenericSuperclass();
		persistencias = (Class<T>) type.getActualTypeArguments()[0];
		entityManager = new JPAUtil().getEntityManager();
	}



	// UMA TRANSAÇÃO DE ENTITY MANAGE É CAPTURADA
	public void inicializa(){
		entityManager.getTransaction().begin();
	}

	// SINCRONIZAR UMA TRANSAÇÃO
	public void commit(){
		entityManager.getTransaction().commit();
	}

	protected void finaliza(){
		entityManager.close();
	}
	
	protected void rowback(){
		entityManager.getTransaction().rollback();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public void salvar(T entidade) {

		try{
			inicializa();
			entityManager.persist(entidade);
			commit();
			//finaliza();
		}catch(RuntimeException e){
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void atualizar(T entidade) {
		try{
			inicializa();
			entityManager.merge(entidade);
			commit();
		}catch(Exception e){
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override 
	public void excluir(T entidade) {
		try{
			inicializa();
			entityManager.remove(entidade);
			commit();
		}catch(RuntimeException e){
			e.printStackTrace();
		}
	}

	@Override
	public void excluirID(Object id) {

		try{
			inicializa();
			entityManager.remove(this.entityManager.getReference(persistencias, id));
			commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pesquisarID(Object id) {
		inicializa();
		T t = null;
		try{
			String classe 	= persistencias.getName();
			String consulta = "SELECT c FROM "+classe+ " c "+" WHERE id = :codigo" ;
			Query query 	= entityManager.createQuery(consulta);
			query.setParameter("codigo", id);
			t 			= (T) query.getSingleResult();
			commit();
			finaliza();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		return t;
	}
	

	@Override
	public T pesquisar(T entidade) {
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos()  {

		List<T> lista =  null;
		try{
			inicializa();
			String classe 	= persistencias.getName();
			String consulta = "SELECT c FROM "+classe+ " c ";
			Query query 	= entityManager.createQuery(consulta);
			lista 			= query.getResultList();
			commit();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}finally{
			finaliza();
		}
		return lista;
	}
}