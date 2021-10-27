package com.project.helpers.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.project.helpers.ClassUtil;

public class HelperCSV<T extends Object> {
  private Class<T> classType;
  private FileWriter fileWriter;
  private BufferedWriter csvWriter;

  public HelperCSV(Class<T> classType) throws Exception {
    this.classType = classType;
    this.csvWriter = this.csvWriterFactory();
    if(!this.csvIsNull())
      this.appendHeaders();
  }

  public void append(T entity) throws Exception {
    this.csvWriter = this.csvWriterFactory();
    String[] values = ClassUtil.getAttributesValues(entity);

    this.csvWriter.write(String.join(",", values)  + "\n");
    this.closeStreams();
  }

  private void appendHeaders() throws Exception {
    String[] headers = ClassUtil.getAttributes(classType);
    this.csvWriter.write(String.join(",", headers) + "\n");
    this.closeStreams();
  }

  private BufferedWriter csvWriterFactory() throws Exception {
    this.fileWriter = new FileWriter(new File("resources/" + this.classType.getSimpleName() + ".csv"), true);
    return new BufferedWriter(fileWriter);
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
