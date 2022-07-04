package com.wmw.treinamento.projetovendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmw.treinamento.projetovendas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
