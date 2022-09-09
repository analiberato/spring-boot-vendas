package com.wmw.treinamento.projeto.controller;

import com.wmw.treinamento.projetovendas.dto.ItemPedidoDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    private PedidoService pedidoService;
    private PedidoDTO pedido;

    @BeforeEach
    public void inicializa() {
        this.pedidoService = new PedidoService();
        this.pedido = criarItem();
    }

    @Test
    void totalDoPedidoDeveriaSerIgualSomaDosItens() {
        Double total = pedidoService.calcularTotalDoPedido(pedido);
        assertEquals(104.50, total);
    }

    @Test
    void deveriaRetornarTotalDoItem() {
        pedidoService.calcularDesconto(pedido.getItens().get(0));
        assertEquals(165.0, pedido.getItens().get(0).getTotalItem());
    }

    private PedidoDTO criarPedido() {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setIdCliente(Long.valueOf("1"));
        pedido.setDataEmissao(LocalDate.parse("2022-09-04"));
        pedido.setDataEntrega(LocalDate.parse("2022-12-04"));
        return pedido;
    }

    private PedidoDTO criarItem() {
        PedidoDTO pedido = criarPedido();
        pedido.getItens().add(new ItemPedidoDTO(Long.parseLong("1"), Long.parseLong("1"), 5.0, 20.90, 5.0, 104.50));
        return pedido;
    }

}
