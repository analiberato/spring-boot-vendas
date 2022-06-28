package com.wmw.treinamento.projetovendas.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wmw.treinamento.projetovendas.model.ItemPedido;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.model.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

	private Long idItemPedido;
	private ProdutoDTO produtoDTO;
	@NotBlank
	@Positive
	private Integer quantidade;
	private Double precoUnitario;
	private Double desconto;
	private Double totalItem;

	public ItemPedidoDTO(ItemPedido item) {
		this.produtoDTO = new ProdutoDTO(item.getProduto());
		this.quantidade = item.getQuantidade();
		this.precoUnitario = item.getPrecoUnitario();
		this.desconto = item.getDesconto();
		this.totalItem = item.getTotalItem();
	}

	public static List<ItemPedidoDTO> converter(List<ItemPedido> itens) {
		return itens.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}

}
