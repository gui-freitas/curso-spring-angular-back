package com.gapp.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gapp.clientes.model.entity.Cliente;
import com.gapp.clientes.model.entity.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente buscaPorId(Integer id) {
		return clienteRepository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	public void deletar(Integer id) {
		clienteRepository
			.findById(id)
			.map(cliente -> {
				clienteRepository.delete(cliente);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	public void atualizar(Integer id, Cliente clienteAtualizado) {
		clienteRepository
		.findById(id)
		.map(cliente -> {
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setCpf(clienteAtualizado.getCpf());
			return clienteRepository.save(cliente);
		})
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	public Page<Cliente> buscarTodos(Integer pagina, Integer tamanhoPagina) {
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
		return clienteRepository.findAll(pageRequest);
	}
}