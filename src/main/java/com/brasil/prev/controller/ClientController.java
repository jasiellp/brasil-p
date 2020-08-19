package com.brasil.prev.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brasil.prev.dao.ClientRepository;
import com.brasil.prev.model.Client;
import com.brasil.prev.model.Clients;

@RestController
@RequestMapping(path = "/client")
public class ClientController 
{
    @Autowired
    private ClientRepository clientRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Clients getEmployees() 
    {
        return clientRepository.getAllClients();
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee( @RequestBody Client client) throws Exception 
    {       
       
        //add resource
    	clientRepository.addClient(client);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{cpf}")
                                    .buildAndExpand(client.getCpf())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
