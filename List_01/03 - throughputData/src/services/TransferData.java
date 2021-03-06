package services;

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
    InputStream is = new FileInputStream("static/" + this.filenameOrigin);
    return is;
  }

  private OutputStream getOutputtream() throws IOException {
    OutputStream os = new FileOutputStream("static/" + this.filenameDestiny);
    return os;
  }

  public void transferFileData() throws IOException {
      InputStream is = this.getInputStream();
      OutputStream os = this.getOutputtream();

      byte[] buffer = new byte[this.sizeOfBytesBlock];

      int read = is.read(buffer);
      while(read != -1) {
        System.out.println("Buffer readed: " + read);
        os.write(buffer);
        read = is.read(buffer);
      }
  }
}
