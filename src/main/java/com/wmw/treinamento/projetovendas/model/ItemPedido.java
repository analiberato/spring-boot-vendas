package com.wmw.treinamento.projetovendas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

	@Id
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;

	private Integer quantidade;

	private Double precoUnitario;

	private Double desconto;

	private Double totalItem;

}
