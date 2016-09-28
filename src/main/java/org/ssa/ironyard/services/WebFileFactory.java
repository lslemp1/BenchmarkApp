package org.ssa.ironyard.services;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;

public class WebFileFactory implements FileFactory {

    final String fileName;

    public WebFileFactory(@Value("corncob_lowercase.txt") String fileName) 
    {
        this.fileName = fileName;
    }

    @Override
    public File getInstance() 
    {
        URL resource = getClass().getClassLoader().getResource(fileName);
        try 
        {
            return new File(resource.toURI());
        }
        catch(URISyntaxException ex)
        {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

}