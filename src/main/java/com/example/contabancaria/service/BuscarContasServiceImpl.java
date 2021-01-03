package com.example.contabancaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.datasource.model.Conta;
import com.example.contabancaria.repository.ContaRepository;

@Service
public class BuscarContasServiceImpl {

	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> buscarTodasAsContas() {
		List<Conta> listConta = contaRepository.findAll();
		return listConta;
	}

}
