package com.example.contabancaria.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.contabancaria.api.dtos.requests.ContaDTORequest;
import com.example.contabancaria.api.dtos.responses.ContaDTOResponse;
import com.example.contabancaria.domain.models.Conta;
import com.example.contabancaria.domain.services.ContaService;

@RestController
@RequestMapping(value = "/")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping(path = "/contas")
	public ResponseEntity<ContaDTOResponse> cadastrarConta(@Valid @RequestBody ContaDTORequest contaDTORequest,
			UriComponentsBuilder uriComponentsBuilder) {

		Conta conta = contaDTORequest.toModel();
		Conta contaSalva = contaService.cadastrar(conta);

		ContaDTOResponse contaDTOResponse = new ContaDTOResponse(contaSalva);

		return ResponseEntity
				.created(uriComponentsBuilder.path("/contas/{id}").buildAndExpand(contaSalva.getId()).toUri())
				.body(contaDTOResponse);
	}

}
