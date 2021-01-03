package com.example.contabancaria.resource.model;

import java.time.LocalDate;

import com.example.contabancaria.datasource.model.Pessoa;

public class PessoaResource {

	private String nome;

	private LocalDate idade;

	private String email;

	private Long cpf;

	public PessoaResource(String nome, LocalDate idade, String email, Long cpf) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.cpf = cpf;
	}
	
	public Pessoa toModel() {
		return new Pessoa(nome, email, cpf, idade);
	}
	
	@Override
	public String toString() {
		return "PessoaResource [nome=" + nome + ", idade=" + idade + ", email=" + email + ", cpf=" + cpf + "]";
	}

}
