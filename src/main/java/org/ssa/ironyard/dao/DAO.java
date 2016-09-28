package org.ssa.ironyard.dao;

public interface DAO<T>
{
    
    T update(T domain);

    T insert(T domain);

    T read(int id);

    boolean delete(int id);

}
