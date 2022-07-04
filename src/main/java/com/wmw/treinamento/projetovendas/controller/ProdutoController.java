package com.wmw.treinamento.projetovendas.controller;

import java.net.URI;
import java.util.List;

import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.model.Produto;
import com.wmw.treinamento.projetovendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wmw.treinamento.projetovendas.dto.ProdutoDTO;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> lista() {
		return ResponseEntity.ok(produtoService.lista());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(produtoService.detalhar(id));
	}

}
