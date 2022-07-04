package com.wmw.treinamento.projetovendas.model;

import javax.persistence.*;

import com.wmw.treinamento.projetovendas.dto.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;

	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> itens = new ArrayList<>();

	public Produto(ProdutoDTO produtoDTO) {
    	this.id = produtoDTO.getId();
    	this.nome = produtoDTO.getNome();
    	this.preco = produtoDTO.getPreco();
    }

}
