package com.gapp.clientes.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ServicoPrestadoDTO {
	
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@NotEmpty(message = "{campo.valor.obrigatorio}")
	private String valor;
	
	@NotEmpty(message = "{campo.dataExecucao.obrigatorio}")
	private String dataExecucao;
	
	@NotNull(message = "{campo.cliente.obrigatorio}")
	private Integer idCliente;
	
	public ServicoPrestadoDTO() { }
	
	public ServicoPrestadoDTO(String descricao, String valor, String dataExecucao, Integer idCliente) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.dataExecucao = dataExecucao;
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}