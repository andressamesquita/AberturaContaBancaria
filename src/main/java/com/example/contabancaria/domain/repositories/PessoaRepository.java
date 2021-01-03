package com.example.contabancaria.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contabancaria.domain.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	
}
