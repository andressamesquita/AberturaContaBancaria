package com.example.contabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contabancaria.datasource.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	
}
