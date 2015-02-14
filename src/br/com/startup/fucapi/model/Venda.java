package br.com.startup.fucapi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="data_hora") @Temporal(value = TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@Column(name="valor_total", precision = 7, scale = 2 )
	private BigDecimal valorTotal;

	@ManyToOne(fetch = FetchType.EAGER) // MUITAS VENDA   UM CONGRESSO PODE TER
	@JoinColumn(referencedColumnName="id") //COMO SE RELACIONAM
	private Congresso congresso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName="id")
	private Administrador administrador; // VARIOS VENDAS PODEM ESTÁ RELACIONADOS A UMA CONTA
	
	@ManyToOne
	private Participante participante;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}
	
}
