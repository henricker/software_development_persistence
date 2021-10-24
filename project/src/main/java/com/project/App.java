package com.project;

import com.project.entity.Developer;
import com.project.services.EntityServiceCSV;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        // HelperCSV<Developer> helperCSV = new HelperCSV<Developer>(Developer.class);
        // helperCSV.append(new Developer("Henrique Vieira", "henricker", "Javascript", Level.SENIOR));

        EntityServiceCSV<Developer> developerServiceCSV = new EntityServiceCSV<>(Developer.class);
        developerServiceCSV.append();
    }
}