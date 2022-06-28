package com.wmw.treinamento.projetovendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmw.treinamento.projetovendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByIdCliente(Long idCliente);

	List<Cliente> findByNome(String nome);

}
