package com.wmw.treinamento.projetovendas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.wmw.treinamento.projetovendas.dto.ItemPedidoDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	private LocalDate dataEmissao;
	private LocalDate dataEntrega;
	private Double totalPedido;

	@Enumerated(EnumType.STRING)
	private StatusPedido status  = StatusPedido.RASCUNHO;;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido(PedidoDTO pedidoDTO) {
		this.idPedido = pedidoDTO.getIdPedido();
		this.cliente = new Cliente(pedidoDTO.getClienteDto());
		this.dataEmissao = pedidoDTO.getDataEmissao();
		this.dataEntrega = pedidoDTO.getDataEntrega();
		this.totalPedido = pedidoDTO.getTotalPedido();
		this.status = pedidoDTO.getStatus();

		for(ItemPedidoDTO itemPedidoDTO : pedidoDTO.getItens()){
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setIdItemPedido(itemPedidoDTO.getIdItemPedido());
			itemPedido.setProduto(new Produto(itemPedidoDTO.getProdutoDTO()));
			itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
			itemPedido.setPrecoUnitario(itemPedidoDTO.getPrecoUnitario());
			itemPedido.setDesconto(itemPedidoDTO.getDesconto());
			itemPedido.setTotalItem(itemPedidoDTO.getTotalItem());

			this.itens.add(itemPedido);
		}
	}
}
