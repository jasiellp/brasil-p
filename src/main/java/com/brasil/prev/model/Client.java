package com.brasil.prev.model;

import com.brasil.prev.util.Util;

public class Client {

    public Client() {

    }

    public Client(String cpf, String firstName, String lastName, String address) {
        super();
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
 
    private String cpf;
    private String firstName;
    private String lastName;
    private String address;

    public String getCpf() {
        return  this.cpf;
    }
    
    public String getCpfFormat() {
        return Util.FormatCPF(this.cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() 
    {
        return "Client [cpf=" + cpf + ", firstName=" + firstName + ", lastName=" + lastName + ", Address=" + address + "]";
    }
}
