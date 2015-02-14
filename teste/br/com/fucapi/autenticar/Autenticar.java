package br.com.fucapi.autenticar;

import org.junit.Ignore;
import org.junit.Test;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.service.AdministradorService;

public class Autenticar {

	@Test
	 // OK
	public void autenticar(){
		String senha  = "87654321";
		String email  = "equipe@gmail.com";
		
		
		AdministradorService service = new AdministradorService();
		Administrador adm  =  service.autenticar(email, senha);
		
		if(adm == null){
			System.out.println("Email e email errado");
		}else{
			System.out.println("Email e senha correto");
		}
		
	}
	
	@Test // OK
	@Ignore
	public void cadastrar(){
		
		Administrador administrador = new Administrador();
		administrador.setEmail("teste@teste");
		administrador.setSenha("12345678");
		
		AdministradorService service = new AdministradorService();
		administrador = service.cadastrarAdministrador(administrador);
		
		if(administrador == null){
			System.out.println("Erro");
		}else{
			System.out.println("Bem vindo");
		}
	}
}
