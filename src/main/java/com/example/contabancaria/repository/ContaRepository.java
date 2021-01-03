package com.example.contabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contabancaria.datasource.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
