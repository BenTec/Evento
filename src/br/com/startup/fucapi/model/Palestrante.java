package br.com.startup.fucapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AttributeOverrides(value = { // SOBRESCREVENDO ATRIBUTOS DAS CLASSES PAI
		@AttributeOverride(name="nome",    column = @Column ), 
		@AttributeOverride(name="contato", column = @Column(length = 15)),
		@AttributeOverride(name="email",   column = @Column)})
public class Palestrante extends Pessoa {

	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="web_site")
	private String webSite;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

}
