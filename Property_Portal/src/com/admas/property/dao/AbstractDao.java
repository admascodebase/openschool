/**
 * 
 */
package com.admas.property.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.admas.property.exception.PropertyBaseException;
import com.admas.property.exception.PropertyErrors;


/**
 * @author amol
 *
 */

public abstract class AbstractDao {
	
	static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(AbstractDao.class);
	private DataSource dataSource;
	
	private InitialContext initialContext ;
	
	/**
	 * @return dataSource
	 */
	public DataSource getDataSource() {
		
		if (dataSource== null)
		{
			try {
				initialContext = new InitialContext();
				dataSource=  (DataSource)initialContext.lookup("java:jboss/datasources/PropertyDS");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				LOG.error("Error in getDataSource - > ",e);
			}
		}
		
		return dataSource;
	}
	/**
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	protected Connection getConnection() throws Exception{
		Connection conn = null;
		try{
			if (dataSource== null)
			{
				getDataSource();
			}
			conn = dataSource.getConnection();
		}catch(Exception e){
			LOG.error("Error in getting database conneciton: ", e);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
		return conn;
	}
	
	protected void closeConnection(Connection con) throws Exception {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception _Ex) {
			LOG.error("Error in closing database connection: ", _Ex);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
	}
	
	protected void closePrepareStatement(PreparedStatement pstmt) throws Exception {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception _Ex) {
			LOG.error("Error in closing database statement: ", _Ex);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
	}
	
	protected void closeResultset(ResultSet rset) throws Exception {
		try {
			if (rset != null) {
				rset.close();
			}
		} catch (Exception _Ex) {
			LOG.error("Error in closing resultset: ", _Ex);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
	}
	
	protected void beginTransaction(Connection con) throws Exception
	{
		try{
			
			con.setAutoCommit(false);
		}catch (Exception _Ex) {
			LOG.error("Error while begin transaction: ", _Ex);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
		
	}
	
	protected void transactionCommitted(Connection con) throws Exception
	{
		try{
			
			con.commit();
		}catch (Exception _Ex) {
			LOG.error("Error while committing transaction: ", _Ex);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
		
	}
	
	protected void transactionRolledBack(Connection con) throws Exception
	{
		try{
			
			con.rollback();
		}catch (Exception _Ex) {
			LOG.error("Error while rollBack the transaction: ", _Ex);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		}
		
	}
	

}
