/**
 * 
 */
package br.com.startup.fucapi.util;

import java.util.Date;
import java.util.Random;

import javax.faces.context.FacesContext;

import br.com.startup.fucapi.model.Administrador;


public class Util {
	
	
		
	// PEGA O ADMINISTRADOR DA SESSAO
	public  static  Administrador pegarUsuarioSessao(){
		Administrador id = (Administrador)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conta");
		return id;
	}

	// RETIRA UM ORGANIZADOR DA SESSAO
	public static void retirarOrganizadorSessao(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("conta");
	}

	//DIA DE HOJE 
	public static Date getHoje(){
		return new Date();
	}
	
	
	// GERACODIGO VERIFICADOR
	public static String gerarCodigo (){
		String codigo = "";
		for(int i = 0; i < 6; i ++){
			Random geradorNumber = new Random();
			codigo += geradorNumber.nextInt(10);
		}
		return codigo;
	}

}
