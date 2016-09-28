package org.ssa.ironyard.services;

import org.ssa.ironyard.model.Framework;

public interface FrameworkService 
{

    Framework read(int id);

    Framework insert(Framework framework);

    Framework update(Framework framework);

    boolean delete(int id);

}
