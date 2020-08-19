package com.brasil.prev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory
{
	
	private Logger logger = Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory INSTANCE;

	public synchronized static ConnectionFactory getInstance() 
	{
		if (INSTANCE == null) 
		{
			INSTANCE = new ConnectionFactory();
		}
		return INSTANCE;
	}
	
	public void close(Connection conn)
	{
		try
		{
			conn.close();
		}
		catch(SQLException ex)
		{
			logger.error(ex);
		}
	}

	public void rollback(Connection conn)
	{
		try
		{
			conn.rollback();
		}
		catch(Exception ex){
			logger.error(ex);
		}
	}	
	
	public void rollbackAndClose(Connection conn)
	{
		try
		{
			conn.rollback();
			conn.close();
		}
		catch(Exception ex)
		{
			logger.error(ex);
		}
	}
	
	public void close(ResultSet rs, PreparedStatement ps)
	{
		try
		{
			rs.close();
			ps.close();
		}
		catch(Exception ex)
		{
			logger.error(ex);
		}
	}

	public void close(PreparedStatement ps)
	{
		try
		{
			ps.close();
		}
		catch(SQLException ex)
		{
			logger.error(ex);
		}
	}
	
	public void commitAndClose(Connection conn)
	{
		try
		{
			conn.commit();
			conn.close();
		}
		catch(SQLException ex)
		{
			logger.error(ex);
		}
	}
	
	public void commit(Connection conn)
	{
		try
		{
			conn.commit();
		}
		catch(SQLException ex)
		{
			logger.error(ex);
		}
	}
 
	public Connection getConnectionPostgre() 
	{
		Connection conn = null;
		
		try 
		{
			Class.forName("org.postgresql.Driver");
		    String dbUrl = System.getProperty("spring.datasource.url"),
		        username = System.getProperty("spring.datasource.username"),
		        password = System.getProperty("spring.datasource.password");
		            conn = DriverManager.getConnection(dbUrl, username, password); 
		}
		catch (Exception ex) 
		{
			logger.error(ex);
		}
		 
		return conn;
		
	} 
}
