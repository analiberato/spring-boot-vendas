package com.wmw.treinamento.projetovendas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	private String nome;
	private Double preco;

    public Produto(Produto produtoDTO) {
    	this.idProduto = produtoDTO.getIdProduto();
    	this.nome = produtoDTO.getNome();
    	this.preco = produtoDTO.getPreco();
    }
}
