package br.com.ujr.isus.salescenter.services.impl;

import java.io.Serializable;

import br.com.ujr.isus.salescenter.services.ITransaction;

public class Transaction implements ITransaction {

	private TransactionType type;
	private Serializable payload;
	
	public TransactionType getTransactionType() {
		return this.type;
	}

	public void setTransactionType(TransactionType type) {
		this.type = type;
	}

	public Serializable getPayload() {
		return this.payload;
	}

	public Serializable setPayload(Serializable payload) {
		return this.payload;
	}

}
