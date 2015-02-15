package br.com.ujr.isus.salescenter.services;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.canonical.messages.ResponseSaveOrder;

public interface ISalesCenterService {
	
	public ResponseSaveOrder placeOrder(Order order);

}
