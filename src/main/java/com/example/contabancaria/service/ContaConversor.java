package com.example.contabancaria.service;
import org.springframework.stereotype.Component;

import com.example.contabancaria.datasource.model.Conta;
import com.example.contabancaria.datasource.model.Pessoa;
import com.example.contabancaria.exception.ContaResourceException;
import com.example.contabancaria.resource.model.ContaResource;

@Component
public class ContaConversor {
	
	public Conta conversor(ContaResource contaResource, Pessoa pessoa) throws ContaResourceException {
		
		try {
			Conta conta = new Conta();
			Long numConta = checkNumConta(contaResource.getNumConta());
			double saldo = checkSaldo(contaResource.getSaldo());
			double limite = checkLimite(contaResource.getLimite());
						
			conta.setNumConta(numConta);
			conta.setSaldo(saldo);
			conta.setLimite(limite);
			conta.setTitular(pessoa);
			
			return conta;
			
		} catch (Exception e) {
			throw new ContaResourceException("Falha ao converter o resource para entidade, resource: " + contaResource);
		}
	}

	private Long checkNumConta(String numConta) {
		return Long.parseLong(numConta);
	}
	
	private double checkSaldo(String saldo) {
		return Double.parseDouble(saldo);
	}
	
	private double checkLimite(String limite) {
		return Double.parseDouble(limite);
	}
}