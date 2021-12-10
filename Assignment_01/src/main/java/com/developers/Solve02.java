package com.developers;

import com.developers.entity.Developer;
import com.developers.services.EntityServiceCSV;

public class Solve02 {
  
  public static void main( String[] args ) throws Exception
  {
      try {
          EntityServiceCSV<Developer> developerServiceCSV = new EntityServiceCSV<>(Developer.class);
          developerServiceCSV.transferToJSONAndXML();
      } catch(Exception err) {
          System.err.println(err);
      }
  }

}
