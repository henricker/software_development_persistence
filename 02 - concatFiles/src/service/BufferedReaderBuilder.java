package service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderBuilder{
  
  private String filename;
  private InputStream inputStream = null;
  private InputStreamReader inputStreamReader = null;
  private BufferedReader bufferedReader = null;

  public BufferedReaderBuilder(String filename) {
    this.filename = filename;
  }

  public BufferedReaderBuilder buildInputStream() throws IOException {
    this.inputStream = new FileInputStream("static/" + this.filename);
    return this;
  }

  public BufferedReaderBuilder buildInputStreamReader() throws IOException {
    this.inputStreamReader = new InputStreamReader(this.inputStream);
    return this;
  }

  public BufferedReader buildBufferedReader() throws IOException {
   this.bufferedReader = new BufferedReader(this.inputStreamReader);
    return this.bufferedReader;
  }
}