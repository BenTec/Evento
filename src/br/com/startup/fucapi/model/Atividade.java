package br.com.startup.fucapi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atividade {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false , precision = 7, scale = 2)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private Integer  vagas;
	
	@Column(name="carga_horaria")
	private Integer cargaHoraria;
	
	@Column(name="hora_inicio", nullable = false)@Temporal(TemporalType.TIME)
	private Date horaInicio;
	
	@Column(name="hora_fim", nullable = false)@Temporal(TemporalType.TIME)
	private Date horaFim;
	
	@Column(name="data_inicio", nullable = false)@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Column(name="data_fim", nullable = false)@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	@ManyToOne() //MUITAS ATIVIDADES UM CONGRESSO PODE TER
	private Congresso congresso;
	
	@ManyToOne() // MUITAS ATIVIDADES UM PALESTRATE PODE MINISTRAR
	private Palestrante palestrante;

	
	// GETERS E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}
	
	
	
	
	
}
