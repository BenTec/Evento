package br.com.startup.fucapi.service;

import java.util.List;

import br.com.startup.com.dao.PalestranteDAO;
import br.com.startup.fucapi.model.Palestrante;

public class PalestranteService {

	PalestranteDAO pDao = new PalestranteDAO();
	
	public PalestranteService() {
		pDao = new PalestranteDAO();
	}
	
	public void salvarPalestrante(Palestrante palestrante){
		pDao.salvar(palestrante);
	}
	
	public void editarPalestrante(Palestrante palestrante){
		pDao.atualizar(palestrante);
	}
	
	public void excluirPalestrante(Palestrante palestrante){
		pDao.excluir(palestrante);
	}
	
	public List<Palestrante> listarPalestrante(){
	 	List<Palestrante>  lista =  pDao.listarTodos();
		return lista;
	}
	
	
}
