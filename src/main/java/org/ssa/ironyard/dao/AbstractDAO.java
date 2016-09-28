package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.ssa.ironyard.controller.DomainObject;

public abstract class AbstractDAO<T extends DomainObject> implements DAO<T>  
{
    final DataSource datasource;
    final ORM<T> orm;

    protected AbstractDAO(DataSource datasource, ORM<T> orm) {
    this.datasource = datasource;
    this.orm = orm;
    }

    public abstract T insert(T domain);

    public boolean delete(int id) {
    Connection connection = null;
    PreparedStatement delete = null;
    try {
        connection = this.datasource.getConnection();
        delete = connection.prepareStatement(this.orm.prepareDelete());
        delete.setInt(1, id);
        if (1 == delete.executeUpdate()) {
        System.err.println("Deleted framework " + id);
        return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cleanup(delete, connection);
    }

    return false;

    }

    public abstract T update(T domain);

    public T read(int id) {
    Connection connection = null;
    PreparedStatement read = null;
    ResultSet results = null;
    try {
        connection = this.datasource.getConnection();
        read = connection.prepareStatement(this.orm.prepareRead());
        read.setInt(1, id);

        results = read.executeQuery();
        if (results.next()) {
        return this.orm.map(results);
        }
    } catch (Exception ex) {

    } finally {
        cleanup(results, read, connection);
    }
    return null;
    }

    static protected void cleanup(ResultSet results, Statement statement, Connection connection) {

    cleanup(results);
    cleanup(statement, connection);
    }

    static protected void cleanup(Statement statement, Connection connection) {

    cleanup(statement);
    cleanup(connection);
    }

    public int clear() throws UnsupportedOperationException {
    Connection connection = null;
    Statement clear = null;
    try {
        connection = this.datasource.getConnection();
        clear = connection.createStatement();
        return clear.executeUpdate("DELETE FROM " + this.orm.table() + ";");

    } catch (Exception e) {

    } finally {
        cleanup(clear, connection);

    }
    return 0;
    }

    static protected void cleanup(AutoCloseable closeable) {
    if (null != closeable)
        try 
        {
        closeable.close();
        }

        catch (Exception ex) 
        {
        }
    }

}
