package com.wmw.treinamento.projetovendas.controller;

import java.net.URI;
import java.util.List;

import com.wmw.treinamento.projetovendas.dto.ClienteDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.dto.ProdutoDTO;
import com.wmw.treinamento.projetovendas.model.Produto;
import com.wmw.treinamento.projetovendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> lista() {
		return ResponseEntity.ok(clienteService.lista());
	}


	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(clienteService.detalhar(id));
	}

}
