package org.ssa.ironyard.model;

import org.ssa.ironyard.controller.DomainObject;

public class Framework implements DomainObject 
{    
    
    int id, errors;
    public String name;
    int thread8, thread16, thread32, thread64, thread128, thread256;
    Languages languages;
    Server server;
    
    public Framework()
    {
        
    }
    
    public Framework(int id, String name, Languages languages, Server server, int thread8, int thread16, int thread32, int thread64, int thread128, int thread256, int errors)
    {
        this.id = id;
        this.name = name;
        this.languages = languages;
        this.server = server;
        this.thread8 = thread8;
        this.thread16 = thread16;
        this.thread32 = thread32;
        this.thread64 = thread64;
        this.thread128 = thread128;
        this.thread256 = thread256;
        this.errors = errors;       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public int getThread8() {
        return thread8;
    }

    public void setThread8(int thread8) {
        this.thread8 = thread8;
    }

    public int getThread16() {
        return thread16;
    }

    public void setThread16(int thread16) {
        this.thread16 = thread16;
    }

    public int getThread32() {
        return thread32;
    }

    public void setThread32(int thread32) {
        this.thread32 = thread32;
    }

    public int getThread64() {
        return thread64;
    }

    public void setThread64(int thread64) {
        this.thread64 = thread64;
    }

    public int getThread128() {
        return thread128;
    }

    public void setThread128(int thread128) {
        this.thread128 = thread128;
    }

    public int getThread256() {
        return thread256;
    }

    public void setThread256(int thread256) {
        this.thread256 = thread256;
    }    
    

}
