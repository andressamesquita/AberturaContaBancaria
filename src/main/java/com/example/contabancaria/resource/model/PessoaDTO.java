package com.example.contabancaria.resource.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.example.contabancaria.datasource.model.Pessoa;

public class PessoaDTO {

	private String nome;

	@Past
	private LocalDate dataNascimento;

	@Email
	private String email;

	@CPF
	private String cpf;

	public PessoaDTO(String nome, LocalDate dataNascimento, String email, String cpf) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.cpf = cpf;
	}
	
	public Pessoa toModel() {
		return new Pessoa(nome, email, cpf, dataNascimento);
	}
	
	@Override
	public String toString() {
		return "PessoaDTO [nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email + ", cpf=" + cpf + "]";
	}

}
