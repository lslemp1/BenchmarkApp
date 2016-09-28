package org.ssa.ironyard.dao;

import java.sql.ResultSet;

import org.ssa.ironyard.model.Server;


public interface ServerORM extends ORM<Server>
{
    @Override
    default String projection() {
    return "id,name";
    }

    default String table() {
    return "server";
    }

    @Override
    default Server map(ResultSet results) throws Exception 
    {       
        return new Server(results.getInt("id"), results.getString("name"));
    }

    @Override
    default String prepareInsert() {
    return "INSERT INTO " + table() + "(name)" + " VALUES(?)";
    }

    @Override
    default String prepareUpdate() {
    return "UPDATE " + table() + " SET name=? WHERE id= ?";
    }

    @Override
    default String prepareRead() {
    return "SELECT " + projection() + " FROM " + table() + " WHERE id=?";
    }

    @Override
    default String prepareDelete() {
    return "DELETE FROM " + table() + " WHERE id = ?";
    }

}
