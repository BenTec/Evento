package br.com.startup.fucapi.service;

import java.util.List;

import br.com.startup.com.dao.CategoriaDAO;
import br.com.startup.fucapi.model.CategoriaCongresso;

public class CategoriaService {
	
	CategoriaDAO cDao = new CategoriaDAO();
	
	public void salvarCategoria(CategoriaCongresso categoria){
		cDao.salvar(categoria);
	}
	
	
	public void excluirCategoria(CategoriaCongresso categoria){
		cDao.excluir(categoria);
	}
	
	public List<CategoriaCongresso> lista(){
		List<CategoriaCongresso> lista = cDao.listarTodos();
		return lista;
	}


}
