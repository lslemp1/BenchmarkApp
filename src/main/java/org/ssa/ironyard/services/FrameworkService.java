package org.ssa.ironyard.services;

import java.util.List;

import org.ssa.ironyard.model.Framework;

public interface FrameworkService 
{

    Framework read(int id);

    Framework insert(Framework framework);

    Framework update(Framework framework);
    
    List<Framework> readAll() throws Exception;

    boolean delete(int id);

}
