package br.com.startup.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.util.Util;

public class AdministradorDAO extends GenericDao<Administrador>{

	EntityManager entityManager;
	public AdministradorDAO() {
		entityManager = getEntityManager();
	}
	
	public Administrador autenticar(String email, String senha){
		
		Administrador administrador = null;
		try{
			inicializa();
			Query query   = entityManager.createNamedQuery("Administrador.autenticar");
			query.setParameter("email", email );
			query.setParameter("senha", senha );
			administrador =  (Administrador) query.getSingleResult();
			commit();
			finaliza();
		}catch(NoResultException e ){
			e.printStackTrace();
		}
		return administrador;
	}

	public Administrador verifcarEmail(String email ){
		
		Administrador administrador = null;
		try{
			inicializa();
			Query query   = entityManager.createNamedQuery("Administrador.recuperar");
			query.setParameter("email", email);
			administrador =(Administrador) query.getSingleResult();
			commit();
	
			if (administrador != null){
				String codigo  =  Util.gerarCodigo(); // GEROU CÓDIGO VERIFICADOR
				administrador.setCodigo(codigo);
				atualizar(administrador);
			}
			finaliza();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return administrador;
	}
	
	public boolean verificarCodigo(String codigo){
		
		try {
			inicializa();
			Query  query = entityManager.createNamedQuery("Administrador.verifcarcod");
			query.setParameter("codigo", codigo);
			String celula = (String) query.getSingleResult();
			commit();
			
			if (!celula.isEmpty()){
				return true;
			}
			finaliza();
		} catch (NoResultException e) {
			e.printStackTrace();
			rowback();
		}
		return false;
	}
	
	public void redefinirSenha(Administrador conta){	
		
		try{
			atualizar(conta);
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			finaliza();
		}
	}
}	
