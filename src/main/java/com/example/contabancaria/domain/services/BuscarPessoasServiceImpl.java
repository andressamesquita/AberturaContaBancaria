package com.example.contabancaria.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.domain.models.Pessoa;
import com.example.contabancaria.domain.repositories.PessoaRepository;

@Service
public class BuscarPessoasServiceImpl {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> buscarTodasAsPessoas() {
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		return listPessoa;
	}
}
