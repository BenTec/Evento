package br.com.fucapi.congresso;

import java.util.List;

import org.junit.Test;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.service.CongressoService;

public class ListarCongressoAdministradoTeste {
	
	@Test // OK
	public void listar(){
		Administrador administrador = new Administrador();
		administrador.setId(2);
		
		CongressoService service = new CongressoService();
		List<Congresso> lista  = service.listarCongresso(administrador);
		
		if (!lista.isEmpty()){
			System.out.println("---------------------------------------");
			for (Congresso congresso : lista) {
					System.out.print("Descricao "+congresso.getDescricao()+" ");
					System.out.print("Titulo "+congresso.getTitulo()+" ");
					System.out.print("Categoria "+congresso.getCategoria().getNome()+" ");
					System.out.print("Endereco "+congresso.getEndereco().getCidade()+" ");
					System.out.println("Valor "+congresso.getValor());
			}
		}
		
	}

}
