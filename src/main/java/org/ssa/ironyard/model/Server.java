package org.ssa.ironyard.model;

import org.ssa.ironyard.controller.DomainObject;

public class Server implements DomainObject 
{
    private int id;
    private String name;
    
    public Server() 
    {

    }
    
    public Server(int id, String name) 
    {
        this.id=id;
        this.name=name;

    }


    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
   
}
