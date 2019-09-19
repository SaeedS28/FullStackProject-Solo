package com.fdmgroup.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {
	private static DataSource ds;
	private ComboPooledDataSource cpds;
	
	private DataSource(){
		cpds = new ComboPooledDataSource();
		Properties properties=null;
		
		
		try(FileReader reader = new FileReader("DBConfiguration.properties");) {
			properties = new Properties();
			properties.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		cpds.setJdbcUrl(properties.getProperty("db.connection.url"));
		cpds.setUser(properties.getProperty("db.username"));
		cpds.setPassword(properties.getProperty("db.password"));
		
		// pooling properties
		cpds.setMinPoolSize(5);			// default 3
		cpds.setMaxPoolSize(20);		// default 15
		cpds.setAcquireIncrement(5);	// default 3	(creates new objects when all have been exhausted
		cpds.setMaxStatements(10);  	// default 0
	}
	
	
	public static DataSource getInstance(){
		if (ds==null){
			ds= new DataSource();
		}
		return ds;
	}
	
	public Connection getConnection() throws SQLException{
		return cpds.getConnection();
	}
}
