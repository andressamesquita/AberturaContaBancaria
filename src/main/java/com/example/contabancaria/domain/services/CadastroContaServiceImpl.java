package com.example.contabancaria.domain.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.api.dtos.requests.ContaResource;
import com.example.contabancaria.api.exceptions.ContaResourceException;
import com.example.contabancaria.domain.models.Conta;
import com.example.contabancaria.domain.models.Pessoa;
import com.example.contabancaria.domain.repositories.ContaRepository;

@Service
public class CadastroContaServiceImpl {

	private static final Logger LOG = Logger.getLogger(CadastroContaServiceImpl.class);

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ContaConversor service;

	public void cadastro(ContaResource contaResource, Pessoa pessoa) {

		try {

			Conta conta = service.conversor(contaResource, pessoa);
			contaRepository.saveAndFlush(conta);

		} catch (ContaResourceException e) {

			LOG.error("Erro ao salvar a conta: " + e.getMessage(), e);
		}
	}

}
