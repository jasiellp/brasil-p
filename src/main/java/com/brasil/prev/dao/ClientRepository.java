package com.brasil.prev.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brasil.prev.model.Client;
import com.brasil.prev.model.Clients;
import com.brasil.prev.util.Util;
 
@Repository
public class ClientRepository  
{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger log = Logger.getLogger(ClientRepository.class);
    private static Clients list = new Clients();
     
    public Clients getAllClients() 
    { 
		String sql = "SELECT cpf, firstName, lastName, address FROM client";
		
		list.getClientList().addAll(jdbcTemplate.query(sql, (rs, rowNum) -> {
			return new Client(Util.FormatCPF(rs.getString("cpf")),rs.getString("firstName"),rs.getString("lastName"),rs.getString("address"));
		}));
		
        return list;
    }
    
    public void addClient(Client client) 
    {
    	StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append("INSERT INTO client (cpf, firstName, lastName, address) ");
		sqlInsert.append(" VALUES (?, ?, ?, ?) ");
		
		int idx =  jdbcTemplate.update(sqlInsert.toString(), new Object[] 
				{ 
					client.getCpf(), 
					client.getFirstName(),
					client.getLastName(), 
					client.getAddress()
				 });
		
		log.info("Status Insert: ".concat(String.valueOf(idx)));
    }
}
