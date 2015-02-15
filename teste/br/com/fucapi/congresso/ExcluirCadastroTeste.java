package br.com.fucapi.congresso;


import org.junit.Test;

import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.service.CongressoService;

public class ExcluirCadastroTeste {
	
	@Test
	public void excluirCongresso(){
		Congresso congresso = new Congresso();
		congresso.setId(8);
		CongressoService  service = new CongressoService();
		service.excluirCongresso(congresso.getId());
	}
}
