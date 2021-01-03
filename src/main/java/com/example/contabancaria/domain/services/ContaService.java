package com.example.contabancaria.domain.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.domain.models.Conta;
import com.example.contabancaria.domain.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Conta cadastrar(Conta conta) {

		verificarDuplicidade(conta);

		String numeroDaConta = gerarNumeroDaConta();
		BigDecimal limiteDaConta = gerarLimiteDaConta();
		conta.setLimite(limiteDaConta);
		conta.setNumeroConta(numeroDaConta);

		return contaRepository.save(conta);

	}

	private void verificarDuplicidade(Conta conta) {
		if (jaExisteEmail(conta.getTitular().getEmail())) {
			throw new IllegalArgumentException("Esse e-mail já existe!");
		}
		if (jaExisteCpf(conta.getTitular().getCpf())) {
			throw new IllegalArgumentException("Esse CPF já existe!");
		}
	}

	private boolean jaExisteCpf(String cpf) {
		Optional<Conta> optional = contaRepository.findByTitularCpf(cpf);
		return optional.isPresent();
	}

	private String gerarNumeroDaConta() {
		return "FAKE-NUMBER-" + String.valueOf(Math.random() * 100000);
	}

	private BigDecimal gerarLimiteDaConta() {
		return BigDecimal.valueOf(Math.random() * 5000);
	}

	private boolean jaExisteEmail(String email) {

		Optional<Conta> optional = contaRepository.findByTitularEmail(email);
		return optional.isPresent();

	}

}
