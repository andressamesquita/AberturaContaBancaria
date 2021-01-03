package com.example.contabancaria.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contabancaria.domain.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	public Optional<Conta> findByTitularEmail(String email);
	
	public Optional<Conta> findByTitularCpf(String cpf);

}