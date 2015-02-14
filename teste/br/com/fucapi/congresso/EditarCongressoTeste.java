package br.com.fucapi.congresso;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.CategoriaCongresso;
import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.model.Endereco;
import br.com.startup.fucapi.service.CategoriaService;
import br.com.startup.fucapi.service.CongressoService;

public class EditarCongressoTeste {
	
	@SuppressWarnings("deprecation")
	@Test
	public void editar(){
		
		CategoriaCongresso categoriaCongresso = new CategoriaCongresso();
		categoriaCongresso.setId(10);
		//categoriaCongresso.setNome("SHOWBOLA");
	
		
		CategoriaService categoriaService = new CategoriaService();
		categoriaService.salvarCategoria(categoriaCongresso);
		
		Administrador administrador = new Administrador();
		administrador.setId(1); 
	
		Endereco endereco = new  Endereco();
		endereco.setId(1L);
		
		
		Congresso congresso = new Congresso();
		congresso.setTitulo("TAdministrador 1");
		congresso.setDescricao("Administrador 1");
		congresso.setCategoria(categoriaCongresso);
	//	congresso.setDataInicio(new Date());
		//congresso.setDataFim(new Date());
		
		Date date = new Date();
		date.setHours(19);
		date.setMinutes(20);
		//congresso.setHoraFim(date);
		//congresso.setHoraInicio(date);
		congresso.setEndereco(endereco);
		congresso.setValor(new BigDecimal(20));
		congresso.setAdministrador(administrador);
		
		CongressoService service = new CongressoService();
		service.editarCongresso(congresso);
	}
}
