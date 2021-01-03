package com.example.contabancaria.domain.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.domain.models.Conta;
import com.example.contabancaria.domain.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	private String gerarNumeroDaConta() {
		return "FAKE-NUMBER-" + String.valueOf(Math.random() * 100000);
	}

	private BigDecimal gerarLimiteDaConta() {
		return BigDecimal.valueOf(Math.random() * 5000);
	}

	public Conta cadastrar(Conta conta) {

		String numeroDaConta = gerarNumeroDaConta();
		BigDecimal limiteDaConta = gerarLimiteDaConta();
		conta.setLimite(limiteDaConta);
		conta.setNumeroConta(numeroDaConta);

		return contaRepository.save(conta);

	}

}
