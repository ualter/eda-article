package br.com.ujr.isus.sales.center.services.mini.js.bam.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {

	private String driver = "com.mysql.jdbc.Driver";
	private String dbURL = "jdbc:mysql://localhost:3306/DbEvents?user=esper&password=esper&autoReconnect=true";

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
			ds.setTestWhileIdle(true);
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
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DataSource.getInstance().getConnection();
		/*PreparedStatement st = conn.prepareStatement("SELECT * FROM TableTotalOrderByCityStream");
		ResultSet rs = st.executeQuery();
		
		while ( rs.next() ) {
			System.out.println(rs.getString(1));
		}*/
	}

}
