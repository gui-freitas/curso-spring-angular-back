package com.gapp.clientes.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}