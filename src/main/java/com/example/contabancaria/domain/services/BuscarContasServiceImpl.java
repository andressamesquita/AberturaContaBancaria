package com.example.contabancaria.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.domain.models.Conta;
import com.example.contabancaria.domain.repositories.ContaRepository;

@Service
public class BuscarContasServiceImpl {

	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> buscarTodasAsContas() {
		List<Conta> listConta = contaRepository.findAll();
		return listConta;
	}

}
