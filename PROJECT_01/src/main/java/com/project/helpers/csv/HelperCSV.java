package com.project.helpers.csv;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.opencsv.CSVWriter;
import com.project.helpers.ClassUtil;

public class HelperCSV<T extends Object> {
  private Class<T> classType;
  private CSVWriter csvWriter;
  private FileWriter fileWriter;

  public HelperCSV(Class<T> classType) throws Exception {
    this.classType = classType;
    this.csvWriter = this.csvWriterFactory();
    if(!this.csvIsNull()) {
      String[] headers = ClassUtil.getAttributes(classType);
      List<String[]> data = new ArrayList<>();
      data.add(headers);
  
      this.csvWriter.writeAll(data, false);
      this.closeStreams();
    }
  }

  public void append(T entity) throws Exception {
    String[] values = ClassUtil.getAttributesValues(entity);
    List<String[]> data = new ArrayList<>();
    data.add(values);

    this.csvWriter = this.csvWriterFactory();
    this.csvWriter.writeAll(data, false);
    this.closeStreams();
  }

  private CSVWriter csvWriterFactory() throws Exception {
    this.fileWriter = new FileWriter(new File("resources/" + this.classType.getSimpleName() + ".csv"), true);
    return new CSVWriter(fileWriter);
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

  }

  private boolean csvIsNull() throws Exception {
    try(Scanner fileScan = new Scanner(new File("resources/" + this.classType.getSimpleName() + ".csv"))) {
      fileScan.nextLine();
      return true;
    } catch(NoSuchElementException err) {
      return false;
    } catch(Exception err) {
      throw err;
    }

  }
}
