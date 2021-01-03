package com.example.contabancaria.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContaResource {

	@JsonProperty("numero_conta")
	private String numConta;
	
	@JsonProperty("saldo")
	private String saldo;
	
	@JsonProperty("limite")
	private String limite;
	
	@JsonProperty("titular")
	private String titular;
	
	
	public ContaResource (String numConta, String titular) {
		this.setNumConta(numConta);
		this.setTitular(titular);
	}


	public String getNumConta() {
		return numConta;
	}


	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}


	public String getSaldo() {
		return saldo;
	}


	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}


	public String getLimite() {
		return limite;
	}


	public void setLimite(String limite) {
		this.limite = limite;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	@Override
	public String toString() {
		return "ContaResource [numConta=" + numConta + ", saldo=" + saldo + ", limite=" + limite + ", titular="
				+ titular + "]";
	}
	
	
	
}
