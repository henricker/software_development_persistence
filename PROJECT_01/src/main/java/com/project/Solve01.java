package com.project;

import java.lang.reflect.InvocationTargetException;
import com.project.entity.Developer;
import com.project.services.EntityServiceCSV;

public class Solve01 
{
    public static void main( String[] args ) throws Exception
    {
        try {
            EntityServiceCSV<Developer> developerServiceCSV = new EntityServiceCSV<>(Developer.class);
            developerServiceCSV.append();
        } catch(InvocationTargetException err) {
            System.out.println("In the level field, only the following values ​​are accepted: PLENO, SENIOR, JUNIOR, INTERN");
        } catch(Exception err) {
            System.err.println(err);
        }
    }
}