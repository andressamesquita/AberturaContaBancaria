package com.example.contabancaria.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contabancaria.domain.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
