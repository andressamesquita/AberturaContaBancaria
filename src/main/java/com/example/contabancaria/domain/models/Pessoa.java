package com.example.contabancaria.domain.models;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Pessoa {
	
	private Long idTitular;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;

	public Pessoa() {

	}

	public Pessoa(String nome, String email, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Long getIdTitular() {
		return idTitular;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

}