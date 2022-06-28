package com.wmw.treinamento.projetovendas.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.wmw.treinamento.projetovendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.model.Pedido;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> lista() {
		return ResponseEntity.ok(pedidoService.lista());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.detalhar(id));
	}

	@PostMapping
	public ResponseEntity<PedidoDTO> cadastrar(@RequestBody @Valid PedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder) {
		PedidoDTO pedido = pedidoService.cadastrar(pedidoDTO);

		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getIdPedido()).toUri();
		return ResponseEntity.created(uri).body(pedidoDTO);
	}


	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PedidoDTO pedidoDTO) {
		return ResponseEntity.ok(pedidoService.atualizar(id, pedidoDTO));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.deletar(id));
	}

}
