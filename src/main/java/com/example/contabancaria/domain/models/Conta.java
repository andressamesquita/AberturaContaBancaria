package com.example.contabancaria.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_conta")
	private String numeroConta;

	private BigDecimal saldo;
	private BigDecimal limite;

	@Embedded
	private Pessoa titular;

	public Conta() {

	}

	public Conta(BigDecimal depositoInicial, Pessoa titular) {
		this.saldo = depositoInicial;
		this.titular = titular;
	}

	public Long getId() {
		return id;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public Pessoa getTitular() {
		return titular;
	}

}
