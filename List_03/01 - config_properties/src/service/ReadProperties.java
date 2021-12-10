package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import helpers.GetScannerFile;
import helpers.ReadPropertiesFile;

public class ReadProperties {

  private String filename;
  private String configPropertiesFilename;

  public ReadProperties(String filename, String configPropertiesFilename) {
    this.filename = filename;
    this.configPropertiesFilename = configPropertiesFilename;
  }

  public void read() throws IOException {
    ReadPropertiesFile rpf = new ReadPropertiesFile(this.configPropertiesFilename);
    Properties prop = rpf.read();
    List<Object> values = new ArrayList<Object>(prop.values());
    List<Object> keys = Collections.list(prop.keys());

    String beginRow = keys.get(0) + "=" + values.get(0);
    String endRow = keys.get(1) + "=" + values.get(1);

    GetScannerFile getScannerFile = new GetScannerFile(this.filename);
    Scanner scannerFile = getScannerFile.getScanner();

    boolean beginRowIsRead = false;

    String line = scannerFile.nextLine();
    while(line != null) {
      if(line.equals(beginRow)) beginRowIsRead = true;
      if(beginRowIsRead) System.out.println(line);
      if(line.equals(endRow)) break;
      line = scannerFile.nextLine();
    }
  }

}
