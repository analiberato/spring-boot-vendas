package com.wmw.treinamento.projetovendas.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wmw.treinamento.projetovendas.model.Produto;

import lombok.Getter;

@Getter
public class ProdutoDTO {

	private Long idProduto;
	private String nome;
	private Double preco;

	public ProdutoDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

	public static List<ProdutoDTO> converter(List<Produto> produto) {
		return produto.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
