package com.example.contabancaria.datasource.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "conta")
public class Conta implements Serializable {
	
	private static final long serialVersionUID = -9119489827087540112L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "numero_conta")
	private Long numConta;
	
	private double saldo;
	private double limite;
	
	@ManyToOne
	@JoinColumn(name="id_titular")
	private Pessoa titular;
	
	
	public Conta() {
		
	}

	public Long getNumConta() {
		return numConta;
	}


	public void setNumConta(Long numConta) {
		this.numConta = numConta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public double getLimite() {
		return limite;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public Pessoa getTitular() {
		return titular;
	}


	public void setTitular(Pessoa pessoa) {
		this.titular = pessoa;
	}
	
}
