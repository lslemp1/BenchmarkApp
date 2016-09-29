package org.ssa.ironyard.dao;

import java.util.List;

import org.ssa.ironyard.model.Framework;

public interface FrameworkDAO extends DAO<Framework> 
{
    public Framework insert(Framework framework);
    
    public Framework update(Framework framework);
    
    public boolean delete(int id);
    
    public Framework read(int id);
    
    public List<Framework> readAll() throws Exception;

    public int clear();
  

}
