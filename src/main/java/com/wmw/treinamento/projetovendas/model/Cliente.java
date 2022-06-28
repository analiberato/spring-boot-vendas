package com.wmw.treinamento.projetovendas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wmw.treinamento.projetovendas.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private String nome;
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	private String cpf_cnpj;
	private String telefone;
	private String email;

	public Cliente(ClienteDTO clienteDto) {
		this.idCliente = clienteDto.getIdCliente();
		this.nome = clienteDto.getNome();
		this.tipoPessoa = clienteDto.getTipoPessoa();
		this.cpf_cnpj = clienteDto.getCpf_cnpj();
		this.telefone = clienteDto.getTelefone();
		this.email = clienteDto.getEmail();
	}
}
