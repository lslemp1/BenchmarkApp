package org.ssa.ironyard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.Languages;
import org.ssa.ironyard.model.Server;

public interface FrameworkORM extends ORM<Framework>
{
    
    default String projection(){
        return "id, name, languages, server, thread8, thread16, thread32, thread64, thread128, thread256, errors";
    }
    
    default String table(){
        return "framework";
    }
    
    @Override
    default Framework map(ResultSet results) {

    Framework temp = new Framework();
    try {
        temp.setId(results.getInt("id"));
        temp.setName(results.getString("name"));
        new Languages(results.getInt("id"), results.getString("name"));
        new Server(results.getInt("id"), results.getString("name"));
        temp.setThread8(results.getInt("thread8"));
        temp.setThread16(results.getInt("thread16"));
        temp.setThread32(results.getInt("thread32"));
        temp.setThread64(results.getInt("thread64"));
        temp.setThread128(results.getInt("thread128"));
        temp.setThread256(results.getInt("thread256"));
        temp.setErrors(results.getInt("errors"));

    } catch (SQLException e) {
        e.printStackTrace();
    }
    //temp.setLoaded();
    return temp;
    }

    @Override
    default String prepareInsert() {
    return "INSERT INTO " + table() + "(name, languages, server, thread8, thread16, thread32, thread64, thread128, thread256, errors)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    default String prepareUpdate() {
    return "UPDATE " + table() + " SET name=?, languages=?, server=?, thread8=?, thread16=?, thread32=?, thread64=?, thread128=?, thread256=?, errors=? WHERE id= ?";
    }

    @Override
    default String prepareRead() {
    return "SELECT " + projection() + " FROM " + table() + " WHERE id=?";
    }

    @Override
    default String prepareDelete() {
    return "DELETE FROM " + table() + " WHERE id = ?";
    }
    
//    @Override 
//    default String prepareSearch(){
//    return "SELECT " + projection() + " FROM " + table() + " WHERE UPPER(name) like UPPER(?) ";
//    }

}
