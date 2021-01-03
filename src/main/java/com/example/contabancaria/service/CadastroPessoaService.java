package com.example.contabancaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.datasource.model.Pessoa;
import com.example.contabancaria.repository.PessoaRepository;

@Service
public class CadastroPessoaService {

	@Autowired 
	private PessoaRepository pessoaRepository;
	
	public Pessoa cadastrar(Pessoa pessoa){
		return pessoaRepository.save(pessoa);
	}
	
}
