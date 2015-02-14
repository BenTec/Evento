package br.com.startup.fucapi.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.service.AdministradorService;
import br.com.startup.fucapi.service.RedirecionarService;
import br.com.startup.fucapi.util.Mensagem;

@ManagedBean
@SessionScoped
public class AutenticarMB {

	private String email;
	private String senha;
	
	private AdministradorService service;
	private Administrador administrador;
	
	@PostConstruct
	public void inicialmente(){
		service = new AdministradorService();
	}
	
	public String solicitarAutenticacao(){	
		
		service = new AdministradorService();
		administrador = service.autenticar(email, senha); 
		
		if (administrador != null){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("conta", administrador);
			return RedirecionarService.redirecionadoLogado();
		}else{
			Mensagem.erro("Email ou senha errado", "");
			return RedirecionarService.redirecionarErro();
		}
	}

	public String solicitarCadastro(){
		
		administrador = service.cadastrarAdministrador(administrador);
		if(administrador != null){
			Mensagem.sucesso("Cadastro realizado com sucesso!", administrador.getEmail());
			return RedirecionarService.redirecionadoLogado();
		}else{
			return RedirecionarService.redirecionarErro();
		}
	}
	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public Administrador getAdministrador() {
		if(administrador == null){
			administrador = new Administrador();
		}
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}
