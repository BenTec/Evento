package br.com.startup.fucapi.mb;

import javax.faces.bean.ManagedBean;

import br.com.startup.fucapi.service.RedirecionarService;

@ManagedBean
public class RedirecionarMB {
	
	
	public String chamarDeslogar(){
		return RedirecionarService.redirecionarDeslogado();
	}
	
	public String chamarCadastro(){
		return RedirecionarService.redirecionarCadastro();
	}
	
	public String chamarRecuperarConta(){
		return RedirecionarService.redirecionrRecuperarConta();
	}
	
	public String chmarCodigoVerificador(){
		return RedirecionarService.redirecionarCodigoVerificado();
	}
	
	public String chamarRedefnirSenha(){
		return RedirecionarService.redirecionarRedefnirSenha();
	}
	
	public String cancelarRedecuperacao(){
		return RedirecionarService.redirecionarCancelarRedefinicao();
	}
}
