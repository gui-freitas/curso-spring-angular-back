package com.gapp.clientes.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gapp.clientes.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer>{

	@Query(" select s from ServicoPrestado s join s.cliente c "
			+ " where upper( c.nome ) like upper( :nome ) "
			+ " and MONTH(s.dataExecucao) =:mes ")
	List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);
}