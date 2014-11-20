package br.com.ujr.isus.tests.Tests;

import java.util.ArrayList;
import java.util.List;

import br.com.ujr.isus.canonical.Customer;
import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.canonical.OrderItem;
import br.com.ujr.isus.canonical.Product;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     * @throws JsonProcessingException
     */
    public static void main( String[] args ) throws JsonProcessingException
    {
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.setSerializationInclusion(Include.NON_NULL);
    	mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Customer customer = Customer.Builder.Instance().id(10)
    												   .name("Ualter")
    												   .city("Sao Paulo")
    												   .country("Brasil").build();
    	List<OrderItem> itens = new ArrayList<OrderItem>();
    	itens.add( OrderItem.Builder.Instance().product(1, "HEADPHONE", 12.30f, Product.Unit.UNITARIO).build()  );
    	itens.add( OrderItem.Builder.Instance().product(2, "MP3 PLAYER", 250.00f, Product.Unit.UNITARIO).build()  );
    	itens.add( OrderItem.Builder.Instance().product(3, "BATTERIES", 5f, Product.Unit.UNITARIO).build()  );
    	Order order = new Order(customer,itens);
    	
    	String json = new String();
    	json = mapper.writeValueAsString(order);
    	System.out.println(json);


    	
    }
}