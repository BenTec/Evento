package br.com.startup.fucapi.service;

import java.util.List;

import br.com.startup.com.dao.CongressoDAO;
import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.Congresso;


public class CongressoService {
	
	private CongressoDAO cDao;
	
	 public CongressoService() {
		cDao = new CongressoDAO();
	 }
	 
	
	public void salvarCongresso(Congresso congresso, Administrador administrador ){
		congresso.setAdministrador(administrador);
		cDao.salvar(congresso);
	}
	
	public void excluirCongresso(Integer id){
		cDao.excluirID(id);
	}
	
	public void excluir(Congresso congresso){
		cDao.excluir(congresso);
	}
	
	public void editarCongresso(Congresso congresso){
		cDao.atualizar(congresso);
	}
	
	
	public List<Congresso>listarCongresso(Administrador administrador){
	 	List<Congresso> lista = cDao.ListarCongressoAdministrador(administrador);
	 	return lista;
	}
	
	
	
}
