package br.com.ujr.esb.services.salesservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.InitializingBean;

public class DBInitialization implements InitializingBean {

	public void afterPropertiesSet() throws Exception {

		String dbURL = "jdbc:derby:dbEvents;create=true";
		// String dbURL = "jdbc:derby:dbEvents";
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE TableTotalOrderByCityStream (CITY VARCHAR(255), QTDE INTEGER)");
		} catch (java.sql.SQLException sqle) {
			String msg = sqle.getLocalizedMessage();
			// Check if we have already before created the Table, just in case we ran several times our message flow 
			if ( msg.contains("Table") && msg.contains("already exists in Schema") ) {
				// That's OK
				return;
			}
			sqle.printStackTrace();
			throw sqle;
		}
	}
}