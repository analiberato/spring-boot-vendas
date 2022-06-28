package com.wmw.treinamento.projetovendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmw.treinamento.projetovendas.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

	Optional<ItemPedido> findById(Long id);

	ItemPedido findByIdItemPedido(Long idItemPedido);

	List<ItemPedido> findAll();

}
