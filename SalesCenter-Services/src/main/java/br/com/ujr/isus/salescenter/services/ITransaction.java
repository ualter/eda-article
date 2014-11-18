package br.com.ujr.isus.salescenter.services;

import java.io.Serializable;

public interface ITransaction {
	
	public enum TransactionType {
		SALE, CANCEL_SALE, STATUS_SALE
	}
	
	public TransactionType getTransactionType();
	public void setTransactionType(TransactionType type);
	
	public Serializable getPayload();
	public Serializable setPayload(Serializable payload);

}
