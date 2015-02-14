package br.com.startup.fucapi.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class  Pessoa {

	
	
	@Column(nullable = true)
	private String nome;
	
	
	@Column(nullable = true)
	private String contato;
	
	
	@Column(nullable = true)
	private String email;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	


}
