package br.com.fucapi.congresso;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.CategoriaCongresso;
import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.model.Endereco;
import br.com.startup.fucapi.service.CongressoService;


public class CadastrarCongressoTeste {
	
	@SuppressWarnings("deprecation")
	@Test
	public void cadastrarCongresso(){
		
		CategoriaCongresso categoriaCongresso = new CategoriaCongresso();
		categoriaCongresso.setId(20);
		//categoriaCongresso.setNome("SHOWBOLA");
	
		
		//CategoriaService categoriaService = new CategoriaService();
		//categoriaService.salvarCategoria(categoriaCongresso);
		
		Administrador administrador = new Administrador();
		administrador.setId(2); // new 
		//administrador.setEmail("liboriojhimmy@gmail.com");
		//administrador.setSenha("12341234");
	
		
		//AdministradorService service = new AdministradorService();
		//service.cadastrarAdministrador(administrador);
		
		Endereco endereco = new  Endereco();
		endereco.setCidade("Manaus");
		endereco.setEstado("am");
		endereco.setCep("69049340");
		endereco.setLogradouro("Rua 18");
		
		Congresso congresso = new Congresso();
		congresso.setTitulo("Confirmacao");
		congresso.setDescricao("Confirmacao");
		congresso.setCategoria(categoriaCongresso);
		congresso.setDataInicio(new Date());
		congresso.setDataFim(new Date());
		
		
		Date date = new Date();
		date.setHours(19);
		date.setMinutes(20);
		congresso.setHoraFim(date);
		congresso.setHoraInicio(date);
		congresso.setEndereco(endereco);
		congresso.setValor(new BigDecimal(20));
		//congresso.setAdministrador(administrador);
		
		CongressoService service = new CongressoService();
		// Na tela vou preencher o congresso e vou pegar o administrado(conta do usuario logado da sessao)
		// Passar para o maagedBean que chamará a camada de serviço (que o professor pediu) e esta chamara o dao 
		// que contem o metodo de salvar
		service.salvarCongresso(congresso, administrador);
		
		Administrador admnistrador = new Administrador();
		admnistrador.setId(2);
		
	
		List<Congresso> lista  = service.listarCongresso(administrador);
		
		if (!lista.isEmpty()){
			System.out.println("---------------------------------------");
			for (Congresso congresso1 : lista) {
					System.out.print("Descricao "+congresso1.getDescricao()+" ");
					System.out.print("Titulo "+congresso1.getTitulo()+" ");
					System.out.print("Categoria "+congresso1.getCategoria().getNome()+" ");
					System.out.print("Endereco "+congresso1.getEndereco().getCidade()+" ");
					System.out.println("Valor "+congresso1.getValor());
			}
		}
		
		
	}
}
