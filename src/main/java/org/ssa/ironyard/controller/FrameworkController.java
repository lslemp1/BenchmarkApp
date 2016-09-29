package org.ssa.ironyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.services.FrameworkServiceImpl;

@RestController
@RequestMapping("/benchmark")
public class FrameworkController 
{
    
    FrameworkServiceImpl fs;
    
    @Autowired
    public FrameworkController(FrameworkServiceImpl fs) 
    {
    this.fs = fs;
    }
    
    @RequestMapping(value = "")
    public View frameworkView() {
    return new InternalResourceView("Framework.html");
    }

    
    @RequestMapping(value = "framework", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Framework>> frameworkList() throws Exception {

        List<Framework> fw = fs.readAll();
        return ResponseEntity.ok().body(fw);
        
    }
    
    
    
}
