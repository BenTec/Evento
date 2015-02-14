package br.com.startup.fucapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

@AttributeOverrides(value = { // SOBRESCREVENDO ATRIBUTOS DAS CLASSES PAI
		@AttributeOverride(name="nome",    column = @Column), 
		@AttributeOverride(name="contato", column = @Column(length = 15)),
		@AttributeOverride(name="email",   column = @Column)})

public class Organizador extends Pessoa {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	
	@ManyToOne() // MUITOS ORGANIZADORES UM CONGRESSO PODE TER
	private Congresso congresso;

	
	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}
	
	
	
}
