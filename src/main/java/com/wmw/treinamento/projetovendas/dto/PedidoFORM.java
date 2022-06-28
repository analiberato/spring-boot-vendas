package com.wmw.treinamento.projetovendas.dto;

import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.model.StatusPedido;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PedidoFORM {

	private Long idPedido;
	private LocalDate dataEntrega;
	@Positive
	private Double totalPedido;
	private StatusPedido status;
	private List<ItemPedidoDTO> itens;

	public PedidoFORM(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.totalPedido = pedido.getTotalPedido();
		this.status = pedido.getStatus();
		//this.itens = new ArrayList<>();
		//this.itens.addAll(pedido.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList()));
	}

	public static List<PedidoFORM> converter(List<Pedido> pedido) {
		return pedido.stream().map(PedidoFORM::new).collect(Collectors.toList());
	}

}
