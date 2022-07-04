package com.wmw.treinamento.projetovendas.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.wmw.treinamento.projetovendas.dto.PedidoUpdateDTO;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
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
	public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(pedidoService.detalhar(id));
	}

	@PostMapping
	public ResponseEntity<PedidoDTO> cadastrar(@RequestBody @Valid PedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder) throws Exception {
		return ResponseEntity.ok(pedidoService.cadastrar(pedidoDTO));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<PedidoUpdateDTO> atualizar(@RequestBody @Valid PedidoUpdateDTO pedidoUpdateDTO) throws Exception {
		return ResponseEntity.ok(pedidoService.atualizar(pedidoUpdateDTO));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.deletar(id));
	}

}
