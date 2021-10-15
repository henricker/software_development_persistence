package com.serializing.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

import com.serializing.contracts.MapperContract;
import com.serializing.helpers.mappers.MapperJSON;
import com.serializing.helpers.mappers.MapperObject;
import com.serializing.helpers.mappers.MapperXML;
import com.serializing.models.Person;

public class MapperServicePerson {
  private List<Person> objects;
  private MapperContract<Person> mapperJSON;
  private MapperContract<Person>  mapperXML;
  private MapperContract<Person> mapperObject;

  public MapperServicePerson() {
    this.objects = Arrays.asList();
    this.mapperJSON = new MapperJSON<Person>();
    this.mapperXML = new MapperXML<Person>();
    this.mapperObject = new MapperObject<Person>();
  }

  public void serialization() throws Exception {
    this.objects = Arrays.asList(
      new Person("Henricker", "henricker@email.com", "8800000000", 21), 
      new Person("Ylana", "ylana@email.com", "008888888888", 21),
      new Person("Clidenor", "clidenor@email.com", "11122233333", 25)
    );

    System.out.println("------ Serializing objects ------");
    for(int i = 0; i < this.objects.size(); i++) {
      Person person = this.objects.get(i);

      new File("resources/" + person.getName()).mkdir();
      mapperJSON.serialization(new FileOutputStream("resources/" + person.getName() + "/object.json"), person);
      mapperXML.serialization(new FileOutputStream("resources/" + person.getName() + "/object.xml"), person);
      mapperObject.serialization(new FileOutputStream("resources/" + person.getName() + "/object.txt"), person);
      System.out.println("generate files to " + person.getName() + ":");
      System.out.println(" - resources/" + person.getName() + "/object.json");
      System.out.println(" - resources/" + person.getName() + "/object.xml");
      System.out.println(" - resources/" + person.getName() + "/object.txt");
    }
  }

  public void desserialization(String mimeType) throws Exception {
    File dir = new File("resources/");
    Integer totalPerson = dir.list().length;
    String[] personsName = dir.list();

    System.out.println("------ Deserializalizing objects by " + mimeType + "------");
    for(int i = 0; i < totalPerson; i++) {
      System.out.println("Actual directory: resources/" + personsName[i]);
      
      switch(mimeType) {
        case "xml":
          System.out.println("- Reading: resources/" + personsName[i] + "/object.xml");
          Person objectFromXML = mapperXML.deserialization(new FileInputStream("resources/" + personsName[i] + "/" + "object.xml"), Person.class);
          System.out.println("- Object: "  + objectFromXML);
          break;
        case "json":
          System.out.println("- Reading: resources/" + personsName[i] + "/object.json");
          Person objectFromJSON = mapperJSON.deserialization(new FileInputStream("resources/" + personsName[i] + "/" + "object.json"), Person.class);
          System.out.println("- Object: " + objectFromJSON);
          break;
        case "txt":
          System.out.println("- Reading: resources/" + personsName[i] + "/object.txt");
          Person objectFromJavaSerialized = mapperObject.deserialization(new FileInputStream("resources/" + personsName[i] + "/" + "object.txt"), Person.class);
          System.out.println("- Object: " + objectFromJavaSerialized);
          break;
        default:
          throw new InvalidParameterException("Only accept mimetypes: xml, json or txt");
      }
    }
  }
}
