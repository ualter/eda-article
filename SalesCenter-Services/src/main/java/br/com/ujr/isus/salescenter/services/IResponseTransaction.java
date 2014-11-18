package br.com.ujr.isus.salescenter.services;

import java.io.Serializable;

public interface IResponseTransaction {

	public boolean isStatus();

	public void setStatus(boolean status);

	public String getErrorMessage();

	public void setErrorMessage(String errorMessage);

	public Serializable getPayload();

	public void setPayload(Serializable payload);

}