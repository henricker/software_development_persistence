package services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransferData {

  String filenameDestiny;
  String filenameOrigin;
  Integer sizeOfBytesBlock;

  public TransferData(String filenameOrigin, String filenameDestiny, Integer sizeOfBytesBlock) {
    this.filenameDestiny = filenameDestiny;
    this.filenameOrigin = filenameOrigin;
    this.sizeOfBytesBlock = sizeOfBytesBlock;
  }

  private InputStream getInputStream() throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream("static/" + this.filenameOrigin), this.sizeOfBytesBlock); 
    return is;
  }

  private OutputStream getOutputtream() throws IOException {
    OutputStream os = new BufferedOutputStream(new FileOutputStream("static/" + this.filenameDestiny), this.sizeOfBytesBlock);
    return os;
  }

  public void transferFileData() throws IOException {
      InputStream is = this.getInputStream();
      OutputStream os = this.getOutputtream();

      byte[] buffer = new byte[this.sizeOfBytesBlock];

      int read = is.read(buffer);
      while(read != -1) {
        os.write(buffer);
        System.out.println("Buffer transfered: " + read);
        read = is.read(buffer);
      }

      is.close();
      os.close();
  }
}
