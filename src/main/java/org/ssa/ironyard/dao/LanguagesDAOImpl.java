package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.api.jdbc.Statement;

public class LanguagesDAOImpl extends AbstractDAO<Languages> implements LanguagesDAO
{
    public LanguagesDAOImpl(DataSource datasource, ORM<Languages> orm) 
    {
        super(datasource, orm);
    }
    
    @Autowired
    public LanguagesDAOImpl(DataSource datasource)
    {
        super(datasource, new LanguagesORM() {        
        });
    }

    @Override
    public Languages insert(Languages language) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet generatedKeys = null;
        try {
            connection = this.datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, language.getName());
            
            if(prepareStatement.executeUpdate()>0){
                generatedKeys = prepareStatement.getGeneratedKeys();
                generatedKeys.next();
                
                Languages lang = new Languages();
                language.setName(lang.getName());
                language.setId(generatedKeys.getInt(1));
                
                return lang;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            cleanup(generatedKeys, prepareStatement, connection);
        }
        return null;
    }

    @Override
    public Languages update(Languages language) 
    {
        Connection connection = null;
        PreparedStatement prepareStatement = null;

        try {
            connection = this.datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareUpdate());
            prepareStatement.setInt(2, language.getId());
            prepareStatement.setString(1, language.getName());
            
            if(prepareStatement.executeUpdate()>0){                               
                Languages lang = new Languages();
                lang.setName(language.getName());
                return lang;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            cleanup(prepareStatement, connection);
        }
        return null;
    }

}
