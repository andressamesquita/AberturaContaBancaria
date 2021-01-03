package com.example.contabancaria.api.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.br.CPF;

import com.example.contabancaria.domain.models.Conta;
import com.example.contabancaria.domain.models.Pessoa;

public class ContaDTORequest {

	private String nome;

	@Past
	private LocalDate dataNascimento;

	@Email
	private String email;

	@CPF
	private String cpf;

	@Positive
	private BigDecimal depositoInicial;

	public ContaDTORequest(String nome, @Past LocalDate dataNascimento, @Email String email, @CPF String cpf,
			@Positive BigDecimal depositoInicial) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.cpf = cpf;
		this.depositoInicial = depositoInicial;
	}

	public Conta toModel() {

		Pessoa pessoa = new Pessoa(nome, email, cpf, dataNascimento);
		Conta conta = new Conta(depositoInicial, pessoa);

		return conta;
	}

}
