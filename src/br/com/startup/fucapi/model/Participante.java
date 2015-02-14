package br.com.startup.fucapi.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@AttributeOverrides(value = { // SOBRESCREVENDO ATRIBUTOS DAS CLASSES PAI
		@AttributeOverride(name="nome",    column = @Column ), 
		@AttributeOverride(name="contato", column = @Column(length = 15)),
		@AttributeOverride(name="email",   column = @Column)})
public class Participante extends Pessoa{
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Temporal(TemporalType.TIME)
	private Date nascimento;
	
	private String cpf;

	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Congresso congresso;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Atividade  atividade;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}


}
