package br.com.ujr.isus.sales.center.services.mini.js.bam;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {

	private String driver = "org.apache.derby.jdbc.ClientDriver";
	private String dbURL = "jdbc:derby:memory:myDB;create=true";

	private static DataSource datasource;
	private BasicDataSource ds;

	private DataSource() {
		this.setUp();
	}

	public void setUp() {
		try {
			Class.forName(driver).newInstance();

			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(dbURL);
			ds.setMinIdle(5);
			ds.setMaxIdle(20);
			ds.setMaxOpenPreparedStatements(180);

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static DataSource getInstance() {
		if (datasource == null) {
			datasource = new DataSource();
		}
		return datasource;
	}

	public Connection getConnection()  {
		try {
			return this.ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
