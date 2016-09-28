package org.ssa.ironyard.dao;

import org.ssa.ironyard.model.Server;

public interface ServerDAO extends DAO<Server>
{
    public Server insert(Server server);
    
    public Server update(Server server);
    
    public boolean delete(int id);
    
    public Server read(int id);

    public int clear();

}
