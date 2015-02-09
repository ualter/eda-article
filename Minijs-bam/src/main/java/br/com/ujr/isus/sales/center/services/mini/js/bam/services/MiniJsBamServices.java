package br.com.ujr.isus.sales.center.services.mini.js.bam.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.ujr.isus.canonical.events.TotalOrderByCity;
import br.com.ujr.isus.sales.center.services.mini.js.bam.db.DataSource;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Named
public class MiniJsBamServices  {

	public List<TotalOrderByCity> getTotalOrderByCity() {
		List<TotalOrderByCity> listTotalOrderByCities = new ArrayList<TotalOrderByCity>();
		
		Connection conn;
		PreparedStatement st;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.prepareStatement("SELECT * FROM TableTotalOrderByCityStream");
			
			ResultSet rs = st.executeQuery();
			while ( rs.next() ) {
				String city = rs.getString(1);
				int    qtde = rs.getInt(2);
				
				TotalOrderByCity t = TotalOrderByCity.Builder.Instance()
											.city(city)
											.total(qtde)
											.build();
				listTotalOrderByCities.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listTotalOrderByCities;
	}

}
