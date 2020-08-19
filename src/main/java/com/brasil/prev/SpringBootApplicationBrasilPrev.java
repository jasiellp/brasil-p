package com.brasil.prev;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

/** 
export M2_HOME=/usr/local/apache-maven-3.6.3/
export M2=$M2_HOME/bin
export PATH=$M2:$PATH

**/ 
@SpringBootApplication
public class SpringBootApplicationBrasilPrev 
{
	
	private static final Logger LOGGER = Logger.getLogger(SpringBootApplicationBrasilPrev.class);
	private static final String[][] TABELAS = { {"client" , "CREATE TABLE ".concat("client").concat("  (cpf  VARCHAR(12) NOT NULL, firstName VARCHAR(80) NOT NULL, lastName VARCHAR(122), address VARCHAR(300) NOT NULL )")}};
	private static final ConnectionFactory CONNECTION = new ConnectionFactory();
    
	
	public static void main(String[] args) 
    {
		criarTabelas();
        SpringApplication.run(SpringBootApplicationBrasilPrev.class, args);
    }
    
    
    
    private static void  criarTabelas() 
    {
		for (int i = 0; i < TABELAS.length; i++) 
		{ 	
			if (tabelaExiste(TABELAS[i][0])) 
			{ 	
				executeStatement("DROP TABLE ".concat(TABELAS[i][0])); 
			}
			
			if (executeStatement(TABELAS[i][1])) 
			{
				LOGGER.info("Tabela ".concat(TABELAS[i][0]).concat(" criada com sucesso.")); 
			}
			else 
			{
				LOGGER.error("Erro ao criar a tabela ".concat(TABELAS[i][0]).concat("."));
			}
		}
	}
    
	private static boolean tabelaExiste(String tabela) 
	{
		boolean existe = false;
		try 
		{
			DatabaseMetaData md = CONNECTION.getConnectionPostgre().getMetaData();
			ResultSet rs = md.getTables(null, null, tabela, null);
			rs.last();
			if (rs.getRow() > 0) existe = true;
		}
		catch (SQLException e) 
		{
			LOGGER.error(e);
		}
		
		return existe;
	}
	
	private static boolean executeStatement(String sql) 
	{
		boolean criado = false;
		try 
		{
			Statement stmt = CONNECTION.getConnectionPostgre().createStatement();
			stmt.executeUpdate(sql);
			criado = true;
		}
		catch (SQLException e) 
		{
			LOGGER.error(e);
		}
		
		return criado;
	}
}
