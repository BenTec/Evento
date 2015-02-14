package br.com.fucapi.Palestrante;

import org.junit.Ignore;
import org.junit.Test;

import br.com.startup.fucapi.model.Palestrante;
import br.com.startup.fucapi.service.PalestranteService;

public class PalestranteTeste {
	Palestrante palestrante = new Palestrante();
	@Test
	@Ignore //OK
	public void salvar(){
		
		palestrante.setNome("Jhimmy Liborio");
		palestrante.setEmail("liborio@gmail.com");
		palestrante.setContato("92720844");
		palestrante.setWebSite("facebook");
		
		PalestranteService service = new PalestranteService();
		service.salvarPalestrante(palestrante);
		
	}
	
	@Test // OK
	@Ignore 
	public void editar(){
		palestrante.setId(1);
		palestrante.setEmail("joel@gmail.com");
		
		PalestranteService service = new PalestranteService();
		service.editarPalestrante(palestrante);
	}
	
	// FALTA EXCLUIR E LISTAR
	
}
