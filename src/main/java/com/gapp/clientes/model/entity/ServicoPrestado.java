package com.gapp.clientes.model.entity;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServicoPrestado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	private BigDecimal valor;
	
	private Instant dataExecucao;

	public ServicoPrestado() { }
	
	public ServicoPrestado(Integer id, String descricao, Cliente cliente, BigDecimal valor, Instant dataExecucao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cliente = cliente;
		this.valor = valor;
		this.dataExecucao = dataExecucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Instant getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(Instant dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
}