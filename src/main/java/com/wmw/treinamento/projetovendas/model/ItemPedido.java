package com.wmw.treinamento.projetovendas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItemPedido;
	@ManyToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;
	private Integer quantidade;
	private Double precoUnitario;
	private Double desconto;
	private Double totalItem;

}
