package com.example.contabancaria.api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.contabancaria.domain.models.Conta;

public class ContaDTOResponse {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private String cpf;
	private String numeroConta;
	private BigDecimal saldo;
	private BigDecimal limite;

	public ContaDTOResponse(Conta conta) {
		this.id = conta.getId();
		this.nome = conta.getTitular().getNome();
		this.dataNascimento = conta.getTitular().getDataNascimento();
		this.email = conta.getTitular().getEmail();
		this.cpf = conta.getTitular().getCpf();
		this.numeroConta = conta.getNumeroConta();
		this.saldo = conta.getSaldo();
		this.limite = conta.getLimite();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public BigDecimal getLimite() {
		return limite;
	}

}
