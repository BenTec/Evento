package br.com.startup.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.Congresso;


public class CongressoDAO extends GenericDao<Congresso> {

	EntityManager entityManager;
	
	public CongressoDAO() {
		entityManager = getEntityManager();
	}


	@SuppressWarnings("unchecked")
	public List<Congresso> ListarCongressoAdministrador(Administrador administrador){
		
		List<Congresso> lista = null;
		try{
			//inicializa();
			Query query = entityManager.createNamedQuery("Congresso.listaAll");
			query.setParameter("codigo", administrador);
			lista = query.getResultList();
			//commit();
			
		}catch(RuntimeException e){
			e.printStackTrace();	
		}
		
		return lista;
	}
	


}
