package br.com.ujr.isus.salescenter.services;

import java.io.Serializable;

public interface ITransaction {
	
	public enum TransactionType {
		SALE, CANCEL_SALE, STATUS_SALE
	}
	
	public Enum<TransactionType> getTransactionType();
	public void setTransactionType(Enum<TransactionType> type);
	
	public Serializable getPayload();
	public Serializable setPayload(Serializable payload);

}
