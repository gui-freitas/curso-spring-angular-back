package com.gapp.clientes.service.exception;

public class UsuarioCadastradoException extends RuntimeException{
	
	public UsuarioCadastradoException(String username) {
		super("Usuário " + username + " já cadastrado!"); 
	}
}
