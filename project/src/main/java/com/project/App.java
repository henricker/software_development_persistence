package com.project;

import java.io.Serializable;
import com.project.helpers.csv.HelperCSV;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        HelperCSV<Test> helperCSV = new HelperCSV<Test>(Test.class);
        helperCSV.append(new Test("henricker", "boa viagem", 21));
    }
}

class Test implements Serializable {
    private String name;
    private String address;
    private Integer age;

    Test(String name, String address, Integer age) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

