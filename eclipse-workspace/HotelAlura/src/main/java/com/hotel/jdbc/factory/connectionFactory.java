package com.hotel.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class connectionFactory {
	
	private DataSource pooledDataSource;
	
	public connectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotelalura?use=TimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("root1234");
		pooledDataSource.setMaxPoolSize(10);
		
		this.pooledDataSource = pooledDataSource;
	}
	public Connection crearConexion(){
			try {
				return this.pooledDataSource.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
