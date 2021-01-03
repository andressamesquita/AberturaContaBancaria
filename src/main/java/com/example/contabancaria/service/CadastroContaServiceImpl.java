package com.example.contabancaria.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contabancaria.datasource.model.Conta;
import com.example.contabancaria.datasource.model.Pessoa;
import com.example.contabancaria.exception.ContaResourceException;
import com.example.contabancaria.repository.ContaRepository;
import com.example.contabancaria.resource.model.ContaResource;

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
