package com.developers;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import com.developers.entity.Developer;
import com.developers.services.EntityServiceCSV;

public class Solve01 
{
    public static void main( String[] args ) throws Exception
    {
        try {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                EntityServiceCSV<Developer> developerServiceCSV = new EntityServiceCSV<>(Developer.class);
                developerServiceCSV.append(scanner);

                System.out.println("\nKeep add developer? 1/0");
                Integer keepAdd = scanner.nextInt();

                if(keepAdd == 0) {
                    scanner.close();
                    break;
                }

                scanner.nextLine();
                System.out.println("");
            }
        } catch(InvocationTargetException err) {
            System.out.println("In the level field, only the following values ​​are accepted: PLENO, SENIOR, JUNIOR, INTERN");
        } catch(Exception err) {
            System.err.println(err);
        }
    }
}