package com.wmw.treinamento.projetovendas.service;

import com.wmw.treinamento.projetovendas.dto.ItemPedidoDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoUpdateDTO;
import com.wmw.treinamento.projetovendas.model.Cliente;
import com.wmw.treinamento.projetovendas.model.ItemPedido;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.model.Produto;
import com.wmw.treinamento.projetovendas.repository.ClienteRepository;
import com.wmw.treinamento.projetovendas.repository.ItemPedidoRepository;
import com.wmw.treinamento.projetovendas.repository.PedidoRepository;
import com.wmw.treinamento.projetovendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemPedidoRepository itemRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public List<PedidoDTO> lista() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return PedidoDTO.converter(pedidos);
    }

    public PedidoDTO detalhar(@PathVariable Long id) throws Exception {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return new PedidoDTO(pedido.get());
        } else {
            throw new Exception();
        }
    }

    public Double calcularTotalDoPedido(PedidoDTO pedidoDTO){
        return pedidoDTO.getItens().stream().mapToDouble(itemPedidoDTO -> itemPedidoDTO.getTotalItem()).sum();
    }

    public Double calcularDesconto(ItemPedidoDTO itemPedidoDTO){
        return ((100 - itemPedidoDTO.getDesconto()) * 0.01) * produtoRepository.getReferenceById(itemPedidoDTO.getIdProduto()).getPreco();
    }

    public PedidoDTO cadastrar(PedidoDTO pedidoDTO) throws Exception {

        if (calcularTotalDoPedido(pedidoDTO) != pedidoDTO.getTotalPedido()){
            throw new Exception();
        }

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoDTO.getId());
        if (pedidoOptional.isPresent()) {
            pedidoRepository.delete(pedidoOptional.get());
        }

        Pedido pedido = new Pedido();

        pedido.setId(pedidoDTO.getId());
        pedido.setTotalPedido(pedidoDTO.getTotalPedido());
        pedido.setDataEmissao(pedidoDTO.getDataEmissao());
        pedido.setDataEntrega(pedidoDTO.getDataEntrega());
        pedido.setStatus(pedidoDTO.getStatus());

        Optional<Cliente> cliente = clienteRepository.findById(pedidoDTO.getIdCliente());
        if (cliente.isPresent()) {
            pedido.setCliente(cliente.get());
        } else {
            throw new Exception();
        }

        pedidoDTO.getItens().stream().forEach(item -> {
            try {
                if (calcularDesconto(item) != item.getTotalItem()){

                    throw new Exception();
                } else {
                    newItemPedido(item, pedido);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        pedidoRepository.save(pedido);
        pedidoDTO = new PedidoDTO(pedido);
         return pedidoDTO;
    }

    private void newItemPedido(ItemPedidoDTO itemPedidoDTO, Pedido pedido) throws Exception {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(itemPedidoDTO.getId());
        itemPedido.setTotalItem(itemPedidoDTO.getTotalItem());
        itemPedido.setDesconto(itemPedidoDTO.getDesconto());
        itemPedido.setPrecoUnitario(itemPedidoDTO.getPrecoUnitario());
        itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());

        itemPedido.setPedido(pedido);

        Optional<Produto> produto = produtoRepository.findById(itemPedidoDTO.getIdProduto());
        if (produto.isPresent()) {
            itemPedido.setProduto(produto.get());
        } else {
            throw new Exception();
        }

        pedido.getItens().add(itemPedido);
    }

    public PedidoUpdateDTO atualizar(PedidoUpdateDTO pedidoUpdateDTO) throws Exception {

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoUpdateDTO.getId());
        if (!pedidoOptional.isPresent()) {
            throw new Exception();
        }

        Pedido pedido = pedidoOptional.get();

        pedido.setId(pedidoUpdateDTO.getId());
        pedido.setTotalPedido(pedidoUpdateDTO.getTotalPedido());
        pedido.setDataEntrega(pedidoUpdateDTO.getDataEntrega());
        pedido.setStatus(pedidoUpdateDTO.getStatus());


        pedidoUpdateDTO.getItens().stream().forEach(item -> {
            Optional<ItemPedido> itemOptional = itemRepository.findById(item.getId());
            if (!itemOptional.isPresent()) {
                try {
                    newItemPedido(item, pedido);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        pedidoRepository.save(pedido);
        pedidoUpdateDTO = new PedidoUpdateDTO(pedido);
        return pedidoUpdateDTO;
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