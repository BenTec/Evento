package br.com.startup.fucapi.service;

import java.util.List;

import br.com.startup.com.dao.AtividadeDAO;
import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.Atividade;


public class AtividadeService {
	
private AtividadeDAO aDao;
	
	 public AtividadeService() {
		 aDao = new AtividadeDAO();
	}
	
	public void salvarAtividade(Atividade atividade){
		aDao.salvar(atividade);
	}
	
	public void excluirAtividade(Atividade atividade){
		aDao.excluir(atividade);
	}
	
	public void atualizarAtividade(Atividade atividade){
		aDao.atualizar(atividade);
	}
	
	public List<Atividade> listarAtividade(Administrador administrador){	
		return null;	
	}
}
