package com.project.services;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.project.helpers.ClassUtil;
import com.project.helpers.csv.HelperCSV;

public class EntityServiceCSV<T extends Object> {
  private Class<T> classType;
  private HelperCSV<T> helperCSV;

  public EntityServiceCSV(Class<T> classType) throws Exception {
    this.classType = classType;
    this.helperCSV = new HelperCSV<>(classType);
  }

  public void append() throws Exception {
    try(Scanner scanner = new Scanner(System.in)) {
      String[] attributes = ClassUtil.getAttributes(this.classType);

      System.out.println("Add the following data to build the entity:");
      Map<String, Object> data = new TreeMap<>();
      for(String att : attributes) {
        System.out.print(att + ": ");
        String value = scanner.next();
        data.put(att, value);
      }

      T entity = ClassUtil.getInstance(this.classType, data);
      this.helperCSV.append(entity);
    }
  }
}
