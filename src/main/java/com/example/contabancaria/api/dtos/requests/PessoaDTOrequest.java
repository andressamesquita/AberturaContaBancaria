package com.example.contabancaria.api.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.example.contabancaria.domain.models.Pessoa;

public class PessoaDTOrequest {

	private String nome;

	@Past
	private LocalDate dataNascimento;

	@Email
	private String email;

	@CPF
	private String cpf;

	public PessoaDTOrequest(String nome, LocalDate dataNascimento, String email, String cpf) {
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
		return "PessoaDTOrequest [nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email + ", cpf=" + cpf + "]";
	}

}
