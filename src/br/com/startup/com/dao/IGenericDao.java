package br.com.startup.com.dao;

import java.util.List;

public interface IGenericDao<T> {
	
	void salvar(T entidade);
	
	void atualizar(T entidade);
	
	void excluir(T entidade);
	
	void excluirID(Object id);
	
	
	T pesquisarID(Object id);
	
	T pesquisar(T entidade); 
	
	List<T> listarTodos();
	
}
