package com.example.contabancaria.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.contabancaria.datasource.model.Conta;
import com.example.contabancaria.exception.ContaNotFoundException;
import com.example.contabancaria.repository.ContaRepository;

@Service
public class BuscarContaPorIdServiceImp {

	@Autowired
	private ContaRepository contaRepository;

	public Conta buscarPorId(Long id) throws ContaNotFoundException {
		Optional<Conta> optionalConta = getOptional(id);

		Conta conta = null;
		if (!optionalConta.isPresent()) {
			throw new ContaNotFoundException("Conta não encontrado atraves do ID: " + id);
		} else {
			conta = optionalConta.get();
		}
		return conta;

	}

	private Optional<Conta> getOptional(Long id) {
		Optional<Conta> optionalConta = contaRepository.findById(id);
		return optionalConta;
	}

	public void deletarPorId(Long id) throws ContaNotFoundException {
		Optional<Conta> optionalConta = getOptional(id);
		if (!optionalConta.isPresent()) {
			throw new ContaNotFoundException("Conta não encontrado atraves do ID: " + id);
		} else {
			contaRepository.delete(optionalConta.get());
		}

	}

}
