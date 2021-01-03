package com.example.contabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contabancaria.datasource.model.Conta;
import com.example.contabancaria.datasource.model.Pessoa;
import com.example.contabancaria.exception.ContaNotFoundException;

import com.example.contabancaria.resource.model.ContaResource;

import com.example.contabancaria.service.BuscarContaPorIdServiceImp;
import com.example.contabancaria.service.BuscarContasServiceImpl;
import com.example.contabancaria.service.CadastroContaServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class ContaController {

	@Autowired
	private BuscarContasServiceImpl serviceBuscar;

	@Autowired
	private CadastroContaServiceImpl serviceCadastro;

	@Autowired
	private BuscarContaPorIdServiceImp serviceBuscarPorId;

	@GetMapping(path = "/contas")
	public List<Conta> buscarContas() {
		return serviceBuscar.buscarTodasAsContas();
	}

	@GetMapping(path = "/conta/id/{id}")
	public Conta buscarContasPorId(@PathVariable(name = "id", required = true) Long id) 
			throws ContaNotFoundException {
		return serviceBuscarPorId.buscarPorId(id);

	}

	@PostMapping(path = "/conta/save")
	public void salvarConta(@RequestBody ContaResource conta, Pessoa pessoa) {
		serviceCadastro.cadastro(conta, pessoa);
	}

	@DeleteMapping(path = "/conta/delete/{id}")
	public void deletePessoa(@PathVariable(name = "id", required = true) Long id) 
			throws ContaNotFoundException {
		serviceBuscarPorId.deletarPorId(id);
	}

}
