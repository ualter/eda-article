package br.com.ujr.isus.sales.center.web;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.ujr.isus.salescenter.services.impl.SalesCenterService;


@ApplicationPath("rest")
public class ApplicationConfig extends Application {
	
	public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(
        		Arrays.asList(
        				SalesCenterService.class
        			   /*,Another.class*/	
        		)
        );
    }

}
