package com.developers.services;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.developers.helpers.ClassUtil;
import com.developers.helpers.csv.HelperCSV;
import com.developers.helpers.mappers.MapperContract;
import com.developers.helpers.mappers.implementations.MapperJSON;
import com.developers.helpers.mappers.implementations.MapperXML;

public class EntityServiceCSV<T extends Object> {
  private Class<T> classType;
  private HelperCSV<T> helperCSV;
  private MapperContract<T> mapperJSON;
  private MapperContract<T> mapperXML;

  public EntityServiceCSV(Class<T> classType) throws Exception {
    this.classType = classType;
    this.helperCSV = new HelperCSV<>(classType);
    this.mapperJSON = new MapperJSON<>();
    this.mapperXML = new MapperXML<>();
  }

  public void append(Scanner scanner) throws Exception {
      String[] attributes = ClassUtil.getAttributes(this.classType);

      System.out.println("Add the following data to build the entity:");
      Map<String, Object> data = new TreeMap<>();
      for(String att : attributes) {
        System.out.print(att + ": ");
        String value = scanner.nextLine();
        data.put(att, value);
      }

      T entity = ClassUtil.getInstance(this.classType, data);
      this.helperCSV.append(entity);
  }

  public void transferToJSONAndXML() throws Exception{
    List<T> entities = this.helperCSV.load();
    System.out.println(entities);

    this.mapperJSON.serializationAll(new FileOutputStream("resources/" + this.classType.getSimpleName() + "/" + this.classType.getSimpleName() + ".json"), entities);
    this.mapperXML.serializationAll(new FileOutputStream("resources/" + this.classType.getSimpleName() + "/" + this.classType.getSimpleName() + ".xml"), entities);
  }
}
