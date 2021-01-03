package com.example.contabancaria.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contabancaria.api.dtos.requests.PessoaDTOrequest;
import com.example.contabancaria.api.exceptions.PessoaNotFoundException;
import com.example.contabancaria.domain.models.Pessoa;
import com.example.contabancaria.domain.services.BuscarPessoaPorIdServiceImp;
import com.example.contabancaria.domain.services.BuscarPessoasServiceImpl;
import com.example.contabancaria.domain.services.CadastroPessoaService;

@RestController
@RequestMapping(value = "/")
public class PessoaController {

	@Autowired
	private BuscarPessoasServiceImpl serviceBuscar;
	
	@Autowired
	private CadastroPessoaService cadastroPessoaService;
	

	@Autowired
	private BuscarPessoaPorIdServiceImp serviceBuscarPorId;

	@GetMapping(path = "/pessoas")
	public List<Pessoa> buscarPessoas() {
		return serviceBuscar.buscarTodasAsPessoas();
	}

	@GetMapping(path = "/pessoas/{id}")
	public Pessoa buscarPessoasPorId(@PathVariable(name = "id", required = true) Long id)
			throws PessoaNotFoundException {
		return serviceBuscarPorId.buscarPorId(id);
	}

	@PostMapping(path = "/pessoas")
	public void salvarPessoa(@RequestBody @Valid PessoaDTOrequest pessoaDTOrequest) {
		Pessoa pessoa = pessoaDTOrequest.toModel();
		cadastroPessoaService.cadastrar(pessoa);
	}

	@DeleteMapping(path = "/pessoas/{id}")
	public void deletePessoa(@PathVariable(name = "id", required = true) Long id) 
			throws PessoaNotFoundException {
		serviceBuscarPorId.deletarPorId(id);
	}

}
