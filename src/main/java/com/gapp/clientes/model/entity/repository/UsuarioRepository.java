package com.gapp.clientes.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.clientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}