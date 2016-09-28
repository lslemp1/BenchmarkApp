package org.ssa.ironyard.dao;

import java.sql.ResultSet;

public interface ORM<T> 
{
    String projection();

    String table();

    T map(ResultSet results) throws Exception;

    String prepareInsert();

    String prepareUpdate();

    String prepareRead();

    String prepareDelete();

}
