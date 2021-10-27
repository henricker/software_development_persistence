package com.project.helpers.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import com.project.helpers.ClassUtil;

public class HelperCSV<T extends Object> {
  private Class<T> classType;
  private FileWriter fileWriter;
  private FileReader fileReader;
  private BufferedWriter csvWriter;
  private BufferedReader csvReader;

  public HelperCSV(Class<T> classType) throws Exception {
    this.classType = classType;
    this.appendHeaders();
  }

  public List<T> load() throws Exception {
    this.csvReader = this.csvReaderFactory();
    List<T> entities = new ArrayList<>();

    String[] headers = this.csvReader.readLine().split(",");
    String values = this.csvReader.readLine();

    while(values != null) {
      String[] valuesSplited = values.split(",");
      Map<String, Object> data = new TreeMap<>();
      for(int i = 0; i < headers.length; i++)
        data.put(headers[i], valuesSplited[i]);
      
      T entity = ClassUtil.getInstance(this.classType, data);
      entities.add(entity);
      values = this.csvReader.readLine();
    }

    this.closeStreams();
    return entities;
  }

  public void append(T entity) throws Exception {
    this.csvWriter = this.csvWriterFactory();
    String[] values = ClassUtil.getAttributesValues(entity);

    this.csvWriter.write(String.join(",", values)  + "\n");
    this.closeStreams();
  }

  private void appendHeaders() throws Exception {
    this.csvWriter = this.csvWriterFactory();
    if(!this.csvIsNull()) {
      String[] headers = ClassUtil.getAttributes(classType);
      this.csvWriter.write(String.join(",", headers) + "\n");
      this.closeStreams();
    }
  }

  private BufferedWriter csvWriterFactory() throws Exception {
    this.fileWriter = new FileWriter(new File("resources/" + this.classType.getSimpleName() + ".csv"), true);
    return new BufferedWriter(fileWriter);
  }

  private BufferedReader csvReaderFactory() throws Exception {
    this.fileReader = new FileReader("resources/" + this.classType.getSimpleName() + ".csv");
    return new BufferedReader(fileReader);
  }

  private void closeStreams() throws Exception {
    if(this.csvWriter != null) {
      this.csvWriter.close();
      this.csvWriter = null;
    }

    if(this.fileWriter != null) {
      this.fileWriter.close();
      this.fileWriter = null;
    }

    if(this.fileReader != null) {
      this.fileReader.close();
      this.fileReader = null;
    }

    if(this.csvReader != null) {
      this.csvReader.close();
      this.csvReader = null;
    }

  }

  private boolean csvIsNull() throws Exception {
    try(Scanner fileScan = new Scanner(new File("resources/" + this.classType.getSimpleName() + ".csv"))) {
      fileScan.nextLine();
      return true;
    } catch(NoSuchElementException err) {
      return false;
    }
  }
}
