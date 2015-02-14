package br.com.startup.fucapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
	@NamedQuery(name = "Administrador.autenticar",  query = "SELECT d        FROM Administrador d WHERE d.email  = :email and d.senha = :senha"),
	@NamedQuery(name = "Administrador.recuperar",   query = "SELECT d  		 FROM Administrador d WHERE d.email  = :email"),
	@NamedQuery(name = "Administrador.verifcarcod", query = "SELECT d.codigo FROM Administrador d WHERE d.codigo = :codigo")
})
@Entity
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true )
	private String email;
	
	@Column(nullable = false, length=32)
	private String senha;
	
	@Column(name="cod_verificador")
	private String codigo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
