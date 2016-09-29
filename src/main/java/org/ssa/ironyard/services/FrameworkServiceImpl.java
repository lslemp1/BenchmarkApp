package org.ssa.ironyard.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ssa.ironyard.dao.FrameworkDAOImpl;
import org.ssa.ironyard.model.Framework;

@Component
public class FrameworkServiceImpl implements FrameworkService
{
    
    FrameworkDAOImpl fw;
    
    @Autowired
    public FrameworkServiceImpl(DataSource datasource) 
    {
        this.fw = new FrameworkDAOImpl(datasource);
    }

    @Override
    @Transactional
    public Framework read(int id) 
    {
        return fw.read(id);
    }
    
    @Override
    @Transactional
    public List<Framework> readAll() throws Exception 
    {
        return fw.readAll();
    }

    @Override
    @Transactional
    public Framework insert(Framework framework) 
    {
        return fw.insert(framework);
    }

    @Override
    @Transactional
    public Framework update(Framework framework) 
    {
        return fw.update(framework);
    }

    @Override
    @Transactional
    public boolean delete(int id) 
    {
        return fw.delete(id);
    }


}
