package br.com.startup.fucapi.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery( name = "Congresso.listaAll", query = "SELECT c  FROM Congresso c WHERE c.administrador = :codigo ")

public class Congresso extends AbstractEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(columnDefinition="text")
	private String descricao;
	
	@Temporal(value = TemporalType.DATE) @Column(name="data_inicio", nullable = false)
	private Date dataInicio;
	
	@Temporal(value = TemporalType.DATE) @Column(name="data_fim", nullable = false)
	private Date dataFim;
	
	@Temporal(value = TemporalType.TIME) @Column(name="hora_inicio", nullable = false)
	@OrderBy("ASC")
	private Date  horaInicio;
	
	@Temporal(value = TemporalType.TIME) @Column(name="hora_fim",nullable = false)
	private Date horaFim;
	
	@Column()
	private Integer vagas;
	
	@Column(nullable = false , precision = 7, scale = 2 )
	private BigDecimal valor;

	@OneToOne(cascade =CascadeType.PERSIST, orphanRemoval=true)
	private Endereco endereco = new Endereco(); // CADA EVENTO TEM UM ENDEREÇO
	
	@OneToOne()  // UM EVENTO TEM UMA CATEGORIA
	private CategoriaCongresso categoria; 

	@ManyToOne(fetch = FetchType.LAZY) // VARIOS EVENTOS PODEM ESTÁ RELACIONADOS A UMA CONTA
	private Administrador administrador;
	
	
	 @OneToMany(mappedBy="congresso",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 private List<Atividade> atividade;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CategoriaCongresso getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaCongresso categoria) {
		this.categoria = categoria;
	}

	public Integer getVagas() {
		return vagas;
	}
	
	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}

}
