package br.com.ujr.isus.salescenter.services.impl;

import java.io.Serializable;

import br.com.ujr.isus.salescenter.services.IResponseTransaction;

public class ResponseTransaction implements IResponseTransaction {

	private boolean status;
	private String errorMessage;
	private Serializable payload;

	public ResponseTransaction(boolean status, String errorMessage,
			Serializable payload) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.payload = payload;
	}

	private ResponseTransaction() {
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Serializable getPayload() {
		return payload;
	}

	public void setPayload(Serializable payload) {
		this.payload = payload;
	}

	public static class Builder {
		private ResponseTransaction response;

		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}

		public Builder status(boolean status) {
			this.response.setStatus(status);
			return this;
		}
		
		public Builder errorMessage(String errorMessage) {
			this.response.setErrorMessage(errorMessage);
			return this;
		}
		
		public Builder payLoad(Serializable payload) {
			this.response.setPayload(payload);
			return this;
		}

		private Builder() {
			this.response = new ResponseTransaction();
		}
		
		public ResponseTransaction build() {
			return this.response;
		}
	}

}
