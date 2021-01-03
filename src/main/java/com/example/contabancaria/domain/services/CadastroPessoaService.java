package com.example.contabancaria.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.domain.models.Pessoa;
import com.example.contabancaria.domain.repositories.PessoaRepository;

@Service
public class CadastroPessoaService {

	@Autowired 
	private PessoaRepository pessoaRepository;
	
	public Pessoa cadastrar(Pessoa pessoa){
		return pessoaRepository.save(pessoa);
	}
	
}
