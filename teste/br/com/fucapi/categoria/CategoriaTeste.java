package br.com.fucapi.categoria;

import org.junit.Test;

import br.com.startup.com.dao.CategoriaDAO;
import br.com.startup.fucapi.model.CategoriaCongresso;

public class CategoriaTeste {
	
	@Test
	public void buscarID(){
		CategoriaCongresso categoriaCongresso = new CategoriaCongresso();
		categoriaCongresso.setId(20);
		CategoriaDAO dao = new CategoriaDAO();
		CategoriaCongresso ca = dao.pesquisarID(categoriaCongresso.getId());
		if(ca == null){
			System.out.println("Nao encontrou");
		}else{
			System.out.println("Encontrou");
		}
	}
}
