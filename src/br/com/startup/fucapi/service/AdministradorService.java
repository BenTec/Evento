package br.com.startup.fucapi.service;

import br.com.startup.com.dao.AdministradorDAO;
import br.com.startup.fucapi.model.Administrador;
import br.com.startup.fucapi.util.EnviarEmail;
import br.com.startup.fucapi.util.Mensagem;

public class AdministradorService {
	
	private AdministradorDAO aDao;
	
	public AdministradorService() {
		aDao = new AdministradorDAO();
	}
	
	
	public Administrador cadastrarAdministrador(Administrador administrador){
		aDao.salvar(administrador); 
		return autenticar(administrador.getEmail(), administrador.getSenha());// REDIRECIONA PARA O PAINEL
	}
	
	public Administrador autenticar(String email, String senha){
		Administrador conta = aDao.autenticar(email, senha);
		return conta;
	}
	
	public Administrador verificarEmail(String email){
		Administrador conta = aDao.verifcarEmail(email);
		System.out.println("Retornando da verificacao");
		if (conta == null){
			System.out.println("conta == null");
		}else{
			System.out.println(conta.getEmail());
		}
		return conta;
	}
	
	/*O ENVIO DO CÓDIGO PODERIA SER FEITO DENTRO DO VERIFICAR EMAIL, POREM A CONEXAO COM O PROVEDOR
	 * PARA ENVIO DO CODIGO AO DESTINATARIO LEVA ALGUNS SEGUNDOS E A PAGINA DE VERIFICAÇAO DE EMAIL
	 * FICA PARADA(NAO REDIRECIONA PARA A PAGINA DE VERIFICACAO DO CODIGO) 
	 * ATÉ QUE O ENVIO SEJA COMPLETADO */
	public void  enviarCodigo(String destinatario, String codigo ){
		
		EnviarEmail.enviarEmail(destinatario, codigo);
	}
	
	public String consultarCodigoVerificador(String codigo){
		
		boolean achou = aDao.verificarCodigo(codigo);
		if (achou){
			return RedirecionarService.redirecionarRedefnirSenha();
		}else{
			Mensagem.erro("Código inválido.", "");
			return RedirecionarService.redirecionarErro(); 
		}
	}
	
	//ID E EMAIL DA SESSAO ,
	public String redefinirSenha(Administrador conta, String novaSenha){
		conta.setSenha(novaSenha);
		aDao.redefinirSenha(conta);
		return RedirecionarService.redirecionadoLogado();
	}
	
	
	
	
}
