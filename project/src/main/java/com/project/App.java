package com.project;

import com.project.entity.Developer;
import com.project.services.EntityServiceCSV;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        EntityServiceCSV<Developer> developerServiceCSV = new EntityServiceCSV<>(Developer.class);
        developerServiceCSV.append();
    }
}