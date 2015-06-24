/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.ngemp.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * The Class NGOPDataSource.
 */
public class NGOPDataSource {
	
	/** The logger. */
	static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(NGOPDataSource.class);
	
	/** The data source. */
	private DataSource dataSource = null;
    
	/**
	 * Instantiates a new NGOP data source.
	 */
	public NGOPDataSource(){
		init();
	}
	

	/**
	 * Inits the datasource.
	 */
	public void init(){
		if(dataSource == null){
			try {
				InitialContext ctx = new InitialContext();
				dataSource=(DataSource)ctx.lookup("java:jboss/datasources/SwiftGatewayDS");
			} catch (NamingException e) {
				LOG.error("error in database connection : "+e);
			}
			
		}
	}
	
	/**
	 * Gets the database connection.
	 *
	 * @return the database connection
	 */
	public Connection getDatabaseConnection(){
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			LOG.error("error in database connection : "+e);
		}
		return connection;
	}
	
	/**
	 * Close database connection.
	 *
	 * @param connection the connection
	 * @return true, if successful
	 */
	public boolean closeDatabaseConnection(Connection connection){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				LOG.error(" error occured : "+e);
			}
		}
		return true;
		
	}
}
