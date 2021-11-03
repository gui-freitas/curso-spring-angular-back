package com.gapp.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gapp.clientes.dto.ServicoPrestadoDTO;
import com.gapp.clientes.model.entity.ServicoPrestado;
import com.gapp.clientes.service.ServicoPrestadoService;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

	@Autowired
	private ServicoPrestadoService servicoPrestadoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		return servicoPrestadoService.salvar(dto);
	}
	
}