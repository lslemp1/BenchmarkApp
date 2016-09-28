package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssa.ironyard.model.Framework;

@Component
public class FrameworkDAOImpl extends AbstractDAO<Framework> implements FrameworkDAO
{


    public FrameworkDAOImpl(DataSource datasource, ORM<Framework> orm) 
    {
        super(datasource, orm);
    }
    
    @Autowired
    public FrameworkDAOImpl(DataSource datasource)
    {
        super(datasource, new FrameworkORM() {        
        });
    }
    
    @Override
    public Framework insert(Framework framework) {
    Connection connection = null;
    PreparedStatement prepareStatement = null;
    ResultSet generatedKeys = null;
    try {
        connection = this.datasource.getConnection();
        prepareStatement = connection.prepareStatement(orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, framework.getName());
        prepareStatement.setInt(2, framework.getLanguages().getId());
        prepareStatement.setInt(3, framework.getServer().getId());
        prepareStatement.setInt(4, framework.getThread8());
        prepareStatement.setInt(5, framework.getThread16());
        prepareStatement.setInt(6, framework.getThread32());
        prepareStatement.setInt(7, framework.getThread64());
        prepareStatement.setInt(8, framework.getThread128());
        prepareStatement.setInt(9, framework.getThread256());
        prepareStatement.setInt(10, framework.getErrors());
        
        if (1 == prepareStatement.executeUpdate()) 
        {
        generatedKeys = prepareStatement.getGeneratedKeys();
        generatedKeys.next();
        
        Framework fram = new Framework();
        framework.setName(fram.getName());
        framework.setLanguages(fram.getLanguages());
        framework.setServer(fram.getServer());
        framework.setThread8(fram.getThread8());
        framework.setThread16(fram.getThread16());
        framework.setThread32(fram.getThread32());
        framework.setThread64(fram.getThread64());
        framework.setThread128(fram.getThread128());
        framework.setThread256(fram.getThread256());
        framework.setErrors(fram.getErrors());
        framework.setId(generatedKeys.getInt(1));
        
        return fram;
       
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cleanup(generatedKeys, prepareStatement, connection);
    }

    return null;
    }
    

    @Override
    public Framework update(Framework framework) {
    PreparedStatement prepareStatement = null;
    Connection connection = null;
    try {
        connection = this.datasource.getConnection();
        prepareStatement = connection.prepareStatement(orm.prepareUpdate());
        prepareStatement.setInt(9, framework.getId());
        prepareStatement.setString(1, framework.getName());
        prepareStatement.setInt(2, framework.getThread8());
        prepareStatement.setInt(3, framework.getThread16());
        prepareStatement.setInt(4, framework.getThread32());
        prepareStatement.setInt(5, framework.getThread64());
        prepareStatement.setInt(6, framework.getThread128());
        prepareStatement.setInt(7, framework.getThread256());
        prepareStatement.setInt(8, framework.getErrors());
        
        if (1 == prepareStatement.executeUpdate()) 
        {
        Framework fram = new Framework();
        framework.setName(fram.getName());
        framework.setThread8(fram.getThread8());
        framework.setThread16(fram.getThread16());
        framework.setThread32(fram.getThread32());
        framework.setThread64(fram.getThread64());
        framework.setThread128(fram.getThread128());
        framework.setThread256(fram.getThread256());
        framework.setErrors(fram.getErrors());
        
        return fram;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cleanup(prepareStatement, connection);
    }

    return null;
    }
    
    
    public int clear() {
    PreparedStatement prepareStatement = null;
    Connection connection = null;
    try {
        connection = this.datasource.getConnection();
        prepareStatement = connection.prepareStatement("DELETE FROM " + orm.table());
        return prepareStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cleanup(prepareStatement, connection);
    }
    return 0;

    }

}
