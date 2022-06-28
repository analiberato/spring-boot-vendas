package com.wmw.treinamento.projetovendas.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.model.StatusPedido;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;

@Data
public class PedidoDTO {

	private Long idPedido;
	private ClienteDTO clienteDto;
	private LocalDate dataEmissao;
	private LocalDate dataEntrega;
	@Positive
	private Double totalPedido;
	private StatusPedido status;
	private List<ItemPedidoDTO> itens;

	public PedidoDTO(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.clienteDto = new ClienteDTO(pedido.getCliente());
		this.dataEmissao = pedido.getDataEmissao();
		this.dataEntrega = pedido.getDataEntrega();
		this.totalPedido = pedido.getTotalPedido();
		this.status = pedido.getStatus();
		//this.itens = new ArrayList<>();
		//this.itens.addAll(pedido.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList()));
	}

	public static List<PedidoDTO> converter(List<Pedido> pedido) {
		return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}

}
