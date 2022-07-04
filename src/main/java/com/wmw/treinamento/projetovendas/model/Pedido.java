package com.wmw.treinamento.projetovendas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.wmw.treinamento.projetovendas.dto.ItemPedidoDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) Isso o total cross vai fazer, bjs <3
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;

	private LocalDate dataEmissao;

	private LocalDate dataEntrega;

	private Double totalPedido;

	@Enumerated(EnumType.STRING)
	private StatusPedido status  = StatusPedido.RASCUNHO;;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();

}