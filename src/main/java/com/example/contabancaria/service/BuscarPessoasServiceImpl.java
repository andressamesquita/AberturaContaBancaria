package com.example.contabancaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.datasource.model.Pessoa;
import com.example.contabancaria.repository.PessoaRepository;

@Service
public class BuscarPessoasServiceImpl {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> buscarTodasAsPessoas() {
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		return listPessoa;
	}
}
