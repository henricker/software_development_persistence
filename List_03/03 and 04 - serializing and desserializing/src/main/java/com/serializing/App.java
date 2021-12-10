package com.serializing;
import com.serializing.services.MapperServicePerson;

public class App {
    public static void main( String[] args ) {
        try {
            MapperServicePerson msp = new MapperServicePerson();
            msp.serialization();

            System.out.println("\n");

            msp.desserialization("json"); // txt, json or xml on params
        } catch(Exception err) {
            System.err.println(err);
        }
    }
}
