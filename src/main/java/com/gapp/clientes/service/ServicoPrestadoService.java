package com.gapp.clientes.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.gapp.clientes.dto.ServicoPrestadoDTO;
import com.gapp.clientes.model.entity.Cliente;
import com.gapp.clientes.model.entity.ServicoPrestado;
import com.gapp.clientes.model.entity.repository.ClienteRepository;
import com.gapp.clientes.model.entity.repository.ServicoPrestadoRepository;
import com.gapp.clientes.util.BigDecimalConverter;
import com.gapp.clientes.util.InstantConverter;

@Service
public class ServicoPrestadoService {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository servicoPrestadoRepository;
	private final BigDecimalConverter bigDecimalConverter;
	private final InstantConverter instantConverter;
	
	public ServicoPrestadoService(ClienteRepository clienteRepository,
								  ServicoPrestadoRepository servicoPrestadoRepository,
								  BigDecimalConverter bigDecimalConverter,
								  InstantConverter instantConverter) {
		super();
		this.clienteRepository = clienteRepository;
		this.servicoPrestadoRepository = servicoPrestadoRepository;
		this.bigDecimalConverter = bigDecimalConverter;
		this.instantConverter = instantConverter;
	}

	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		Integer idCliente = dto.getIdCliente();
		
		Cliente cliente = 
				clienteRepository
				.findById(idCliente)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe!"));
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setDataExecucao(instantConverter.converter(dto.getDataExecucao()));
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getValor()));
		
		return servicoPrestadoRepository.save(servicoPrestado);
	}
}
