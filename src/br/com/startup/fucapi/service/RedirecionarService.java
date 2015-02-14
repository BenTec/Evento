package br.com.startup.fucapi.service;

import javax.faces.context.FacesContext;

import br.com.startup.fucapi.util.Util;

public class RedirecionarService {
	
	
	private static String logar     = "/pages/adm/painel-adm.xhtml?faces-redirect=true";
	private static String home      = "/pages/public/login.xhtml?faces-redirect=true";
	private static String cadastrar = "cadastrar";
	
	private static String recuperarConta 	= "/pages/recuperar/recuperar.xhtml?faces-redirect=true";
	private static String codigoVerificador = "/pages/recuperar/cod-verificador.xhtml?faces-redirect=true";
	private static String redefinir 		= "/pages/recuperar/redefinir.xhtml?faces-redirect=true";
	
	
	
	public static String redirecionadoLogado(){
		return logar;
	}
	
	public static String redirecionarDeslogado(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		Util.retirarOrganizadorSessao();
		return home;
	}
	

	public static String redirecionarErro(){
		return "";
	}


	//----REDIRECIONAMENTO DE PAGINAS (RECUPERAR SENHA) ----
	public static String redirecionarCadastro(){
		return cadastrar;
	}
	
	public static String redirecionrRecuperarConta(){
		return recuperarConta;
	}
	
	public static String redirecionarCodigoVerificado(){
		return codigoVerificador;
	}
	
	public static String redirecionarRedefnirSenha(){
		return redefinir;
	}
	
	public static String redirecionarCancelarRedefinicao(){
		return home;
	}
	//---FIM REDIRECIONAMENTO DE PÁGINAS (RECUPERAR SENHA) ---
}
