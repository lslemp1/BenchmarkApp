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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + errors;
        result = prime * result + id;
        result = prime * result + ((languages == null) ? 0 : languages.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((server == null) ? 0 : server.hashCode());
        result = prime * result + thread128;
        result = prime * result + thread16;
        result = prime * result + thread256;
        result = prime * result + thread32;
        result = prime * result + thread64;
        result = prime * result + thread8;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Framework other = (Framework) obj;
        if (errors != other.errors)
            return false;
        if (id != other.id)
            return false;
        if (languages == null) {
            if (other.languages != null)
                return false;
        } else if (!languages.equals(other.languages))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (server == null) {
            if (other.server != null)
                return false;
        } else if (!server.equals(other.server))
            return false;
        if (thread128 != other.thread128)
            return false;
        if (thread16 != other.thread16)
            return false;
        if (thread256 != other.thread256)
            return false;
        if (thread32 != other.thread32)
            return false;
        if (thread64 != other.thread64)
            return false;
        if (thread8 != other.thread8)
            return false;
        return true;
    }  
    
    
    

}
