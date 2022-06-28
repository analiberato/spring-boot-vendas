package com.wmw.treinamento.projetovendas.service;

import com.wmw.treinamento.projetovendas.dto.ClienteDTO;
import com.wmw.treinamento.projetovendas.dto.PedidoDTO;
import com.wmw.treinamento.projetovendas.model.Cliente;
import com.wmw.treinamento.projetovendas.model.Pedido;
import com.wmw.treinamento.projetovendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDTO.converter(clientes);
	}

	public ClienteDTO detalhar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return new ClienteDTO(cliente.get());
		} else {
			//new Exception()
		}
	}
}
