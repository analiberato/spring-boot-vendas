package com.wmw.treinamento.projetovendas.service;

import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.dto.ProdutoDTO;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.model.Produto;
import com.wmw.treinamento.projetovendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> lista() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDTO.converter(produtos);
	}

	public ProdutoDTO detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return new ProdutoDTO(produto.get());
		} else {
			return new Exception();
		}
	}
}
