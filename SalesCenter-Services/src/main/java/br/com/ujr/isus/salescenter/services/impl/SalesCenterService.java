package br.com.ujr.isus.salescenter.services.impl;

import javax.ws.rs.Path;

import br.com.ujr.isus.salescenter.services.IResponseTransaction;
import br.com.ujr.isus.salescenter.services.ISalesCenterService;
import br.com.ujr.isus.salescenter.services.ITransaction;
import br.com.ujr.isus.salescenter.services.facade.SalesCenterFacade;
import br.com.ujr.isus.salescenter.services.model.Sale;

@Path("/salescenter")
public class SalesCenterService implements ISalesCenterService {
	
	private SalesCenterFacade facade = new SalesCenterFacade();
	
	public IResponseTransaction executeTransaction(ITransaction transaction) {
		
		ResponseTransaction response = ResponseTransaction.Builder.Instance()
										.status(false)
										.payLoad(null)
										.errorMessage(null)
										.build();
		
		switch ( transaction.getTransactionType() ) {
		case SALE: {
			Sale sale = this.extractPayload(transaction);
			facade.registerSale(sale);
			response.setStatus(true);
			break;
		}
		case CANCEL_SALE: {
			Sale sale = this.extractPayload(transaction);
			facade.cancelSale(sale);
			response.setStatus(true);
			break;
		}
		case STATUS_SALE: {
			Sale sale = this.extractPayload(transaction);
			facade.getStatusSale(sale);
			response.setStatus(true);
			break;
		}
		default:
			break;
		}
		
		return response;
	}
	
	private Sale extractPayload(ITransaction transaction) {
		return (Sale)transaction.getPayload();
	}

}
