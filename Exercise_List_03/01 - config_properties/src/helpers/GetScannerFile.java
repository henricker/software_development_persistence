package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class GetScannerFile {
  private String filename;

  public GetScannerFile(String filename) {
    this.filename = filename;
  }

  public Scanner getScanner() throws IOException {
    Scanner scannerFile = new Scanner(new FileInputStream("resources/" + this.filename));
    return scannerFile;
  }
}
