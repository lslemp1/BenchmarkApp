package org.ssa.ironyard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.ssa.ironyard.services.FrameworkService;

@RestController
@RequestMapping("/benchmark")
public class FrameworkController 
{
    
    FrameworkService fs;
    
    @Autowired
    public FrameworkController(FrameworkService fs) 
    {
    this.fs = fs;
    }
    
    @RequestMapping(value = "")
    public View frameworkView() {
    return new InternalResourceView("Framework.html");
    }

    
    
    
    
}
