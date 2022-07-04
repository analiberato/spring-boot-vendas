package com.wmw.treinamento.projetovendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmw.treinamento.projetovendas.model.Cliente;
import com.wmw.treinamento.projetovendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
