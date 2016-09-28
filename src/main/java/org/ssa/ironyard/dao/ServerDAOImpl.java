package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.ssa.ironyard.model.Server;

import com.mysql.cj.api.jdbc.Statement;

public class ServerDAOImpl extends AbstractDAO<Server> implements ServerDAO
{
    public ServerDAOImpl(DataSource datasource, ORM<Server> orm) 
    {
        super(datasource, orm);
    }
    
    @Autowired
    public ServerDAOImpl(DataSource datasource)
    {
        super(datasource, new ServerORM() {
      
        });
    }

    @Override
    public Server insert(Server server) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet generatedKeys = null;
        try {
            connection = this.datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, server.getName());
            
            if(prepareStatement.executeUpdate()>0){
                generatedKeys = prepareStatement.getGeneratedKeys();
                generatedKeys.next();
                
                Server serv = new Server();
                server.setName(serv.getName());
                server.setId(generatedKeys.getInt(1));
                
                return serv;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            cleanup(generatedKeys, prepareStatement, connection);
        }
        return null;
    }

    @Override
    public Server update(Server server) 
    {
        Connection connection = null;
        PreparedStatement prepareStatement = null;

        try {
            connection = this.datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareUpdate());
            prepareStatement.setInt(2, server.getId());
            prepareStatement.setString(1, server.getName());
            
            if(prepareStatement.executeUpdate()>0){                               
                Server serv = new Server();
                serv.setName(server.getName());
                return serv;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            cleanup(prepareStatement, connection);
        }
        return null;
    } 


}
