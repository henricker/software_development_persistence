package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

  public BufferedReaderBuilder buildInputStream() throws FileNotFoundException {
    this.inputStream = new FileInputStream("static/" + this.filename);
    return this;
  }

  public BufferedReaderBuilder buildInputStreamReader() throws FileNotFoundException {
    this.inputStreamReader = new InputStreamReader(this.inputStream);
    return this;
  }

  public BufferedReader buildBufferedReader() throws FileNotFoundException {
   this.bufferedReader = new BufferedReader(this.inputStreamReader);
    return this.bufferedReader;
  }
}
