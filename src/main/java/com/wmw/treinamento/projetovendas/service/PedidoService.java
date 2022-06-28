package com.wmw.treinamento.projetovendas.service;

import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<PedidoDTO> lista() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return PedidoDTO.converter(pedidos);
    }

    public PedidoDTO cadastrar(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido(pedidoDTO);
        pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);
    }

    public PedidoDTO detalhar(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return new PedidoDto(pedido.get());
        } else {
            //new Exception()
        }
    }

    public PedidoDTO atualizar(@PathVariable Long id, PedidoDTO pedidoDto) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        //PedidoDTO pedidoDTO;
        if (pedido.isPresent()) {
            //pedido.get().setDataEntrega(pedidoDto.getDataEntrega());
            //pedido.get().setTotalPedido(pedidoDto.getTotalPedido());
            //pedido.get().setStatus(pedidoDto.getStatus());
            //pedido.get().setItens(pedidoDto.getItens());
            return new PedidoDTO(pedido.get());
        } else {
            //new Exception()
        }

    }

    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}