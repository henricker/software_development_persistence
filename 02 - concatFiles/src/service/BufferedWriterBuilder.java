package service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BufferedWriterBuilder{
  
  private String filename;
  private OutputStream outputStream = null;
  private OutputStreamWriter outputStreamWriter = null;
  private BufferedWriter bufferedWriter = null;

  public BufferedWriterBuilder(String filename) {
    this.filename = filename;
  }

  public BufferedWriterBuilder buildOutputStream() throws IOException {
    this.outputStream = new FileOutputStream("static/" + this.filename);
    return this;
  }

  public BufferedWriterBuilder buildOutputStreamWriter() throws IOException {
    this.outputStreamWriter = new OutputStreamWriter(this.outputStream);
    return this;
  }

  public BufferedWriter buildBufferedWriter() throws IOException {
   this.bufferedWriter = new BufferedWriter(this.outputStreamWriter);
    return this.bufferedWriter;
  }
}