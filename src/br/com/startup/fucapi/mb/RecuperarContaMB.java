package br.com.startup.fucapi.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.service.AdministradorService;
import br.com.startup.fucapi.service.RedirecionarService;
import br.com.startup.fucapi.util.Mensagem;
import br.com.startup.fucapi.util.Util;


/**
 * Alguns redirecionamentos estão sendo feito por aqui, pois alguns métodos necessitam 
 * colocar informações na sessão para posteriormente auxiliar na recuperação da conta
 * 
 * */
@ManagedBean
@ViewScoped
public class RecuperarContaMB {
	
	private String novaSenha;
	private String emailInfo;
	private String codigoInfo;
	private AdministradorService service;
	Administrador administrador = null;
	

	
	@PostConstruct // ANTES DE RENDERIZAR A PÁGINA
	public void inicialmente(){
		service = new AdministradorService();
	}
	
	
	public String chamarVerificadorEmail(){
		
		administrador = service.verificarEmail(emailInfo);
		if (administrador != null){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("conta", administrador);
			return RedirecionarService.redirecionarCodigoVerificado();
		}else{
			Mensagem.alerta("A sua pesquisa não encontrou nenhum resultado. Por favor, tente novamente com outras informações.","");
			return RedirecionarService.redirecionarErro(); //FICA NA MESMA PÁGINA
		}
	}
	
	public void chamarEnviadorCodigo(){
		administrador = Util.pegarUsuarioSessao();
		service.enviarCodigo(administrador.getEmail(), administrador.getCodigo());
	}
	
	public String chamarVerificadorCodigo(){
		return service.consultarCodigoVerificador(codigoInfo);
	}
	
	
	public String chamarRedefinicaoSenha(){
		Administrador conta = Util.pegarUsuarioSessao();
		return service.redefinirSenha(conta, novaSenha);
	}
	
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	public void setEmailInfo(String emailInfo) {
		this.emailInfo = emailInfo;
	}
	
	public void setCodigoInfo(String codigoInfo) {
		this.codigoInfo = codigoInfo;
	}
	
	public String getEmailInfo() {
		return emailInfo;
	}
	
	public String getCodigoInfo() {
		return codigoInfo;
	}
	
	public String getNovaSenha() {
		return novaSenha;
	}
}
