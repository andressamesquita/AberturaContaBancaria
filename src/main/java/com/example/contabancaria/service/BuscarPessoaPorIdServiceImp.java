package com.example.contabancaria.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.contabancaria.datasource.model.Pessoa;
import com.example.contabancaria.exception.PessoaNotFoundException;
import com.example.contabancaria.repository.PessoaRepository;

@Service
public class BuscarPessoaPorIdServiceImp {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa buscarPorId(Long id) throws PessoaNotFoundException {
		Optional<Pessoa> optionalPessoa = getOptional(id);

		Pessoa pessoa = null;
		if (!optionalPessoa.isPresent()) {
			throw new PessoaNotFoundException("Cliente não encontrado atraves do ID: " + id);
		} else {
			pessoa = optionalPessoa.get();
		}
		return pessoa;

	}

	private Optional<Pessoa> getOptional(Long id) {
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
		return optionalPessoa;
	}

	public void deletarPorId(Long id) throws PessoaNotFoundException {
		Optional<Pessoa> optionalPessoa = getOptional(id);
		if (!optionalPessoa.isPresent()) {
			throw new PessoaNotFoundException("Cliente não encontrado atraves do ID: " + id);
		} else {
			pessoaRepository.delete(optionalPessoa.get());
		}
	}
}
