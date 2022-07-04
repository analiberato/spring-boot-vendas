package com.wmw.treinamento.projetovendas.model;

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
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	private String cpf_cnpj;
	private String telefone;
	private String email;

	public Cliente(ClienteDTO clienteDto) {
		this.id = clienteDto.getId();
		this.nome = clienteDto.getNome();
		this.tipoPessoa = clienteDto.getTipoPessoa();
		this.cpf_cnpj = clienteDto.getCpf_cnpj();
		this.telefone = clienteDto.getTelefone();
		this.email = clienteDto.getEmail();
	}
}
