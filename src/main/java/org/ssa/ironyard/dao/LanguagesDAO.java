package org.ssa.ironyard.dao;

import org.ssa.ironyard.model.Languages;

public interface LanguagesDAO extends DAO<Languages> 
{
    public Languages insert(Languages languages);
    
    public Languages update(Languages languages);
    
    public boolean delete(int id);
    
    public Languages read(int id);

    public int clear();

}
