package br.com.startup.fucapi.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.model.CategoriaCongresso;
import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.service.CategoriaService;
import br.com.startup.fucapi.service.CongressoService;
import br.com.startup.fucapi.util.Mensagem;

@ManagedBean
@ViewScoped
public class CongressoMb implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	
	private List<Congresso> lista;
	private List<CategoriaCongresso> listCategoria;
	private Congresso congresso;
	private CongressoService service;
	private CategoriaService cservice;
	private Administrador administrador;// trocar para a conta do adm que esta na sessão
	boolean skip;
	
	
	@PostConstruct
	public void preRenderView(){
		service  = new CongressoService();
		cservice = new CategoriaService();
		administrador = new Administrador();
		administrador.setId(1);
		lista = service.listarCongresso(administrador);
		listCategoria = cservice.lista();
	}
	
	
	public void serviceCadastro(){
		service.salvarCongresso(congresso, administrador);
		Mensagem.sucesso("Salvo", "Evento "+congresso.getTitulo());
		lista = service.listarCongresso(administrador); 
	}
	
	
	public void serviceEditar(){
		service.editarCongresso(congresso);
		lista = service.listarCongresso(administrador); //ATUALIZAR A LISTA DE CONGRESSO
	}
	
	
	public void serviceExcluir(){
		service.excluirCongresso(congresso);
		lista = service.listarCongresso(administrador); 
	}


	public void refresh() {    
	      FacesContext context = FacesContext.getCurrentInstance();    
	      Application application = context.getApplication();    
	      ViewHandler viewHandler = application.getViewHandler();    
	      UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());    
	      context.setViewRoot(viewRoot);    
	      context.renderResponse();    
	  }   
	
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reseta em caso de usuario voltar.
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
	}



	public List<Congresso> getLista() {
		return lista;
	}


	public void setLista(List<Congresso> lista) {
		this.lista = lista;
	}


	public List<CategoriaCongresso> getListCategoria() {
		return listCategoria;
	}


	public void setListCategoria(List<CategoriaCongresso> listCategoria) {
		this.listCategoria = listCategoria;
	}


	public Congresso getCongresso() {
		if (congresso == null){
			congresso = new Congresso();
		}
		return congresso;
	}


	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}


	public boolean isSkip() {
		return skip;
	}


	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	
	
	
	

}
