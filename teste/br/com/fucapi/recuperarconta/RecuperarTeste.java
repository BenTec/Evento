package br.com.fucapi.recuperarconta;

import org.junit.Ignore;
import org.junit.Test;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.service.AdministradorService;
import br.com.startup.fucapi.util.EnviarEmail;

public class RecuperarTeste {
	
	@Test
	@Ignore
	public void  email(){
		String email = "equipe@gmail.com";
		AdministradorService service = new AdministradorService();
		Administrador administrador  = service.verificarEmail(email);
		System.out.println(administrador.getEmail());
	}
	
	@Test
	@Ignore
	public void verificarCodigo(){
		String codigo = "985921";
		AdministradorService service = new AdministradorService();
		String pagina =  service.consultarCodigoVerificador(codigo);
		
		if (!pagina.isEmpty()){
			System.out.println("Código correto");
		}else{
			System.out.println("Código errado");
		}
	}
	
	@Test
	@Ignore
	public void enviarEmail(){
		String destinatario  = "claraaa.bf@gmail.com";
		String codigo = "985921";
		
		EnviarEmail.enviarEmail(destinatario, codigo);
	}
	
	@Test
	
	public void redefinirSenha(){
		Administrador administrador = new Administrador();
		administrador.setId(1);
		administrador.setEmail("equipe@gmail.com");
		String novaSenha = "87654321";
		
		
		AdministradorService service = new AdministradorService();
		service.redefinirSenha(administrador, novaSenha);
	}
	
}
