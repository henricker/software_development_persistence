package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
  private String filename;
  public ReadPropertiesFile(String filename) {
    this.filename = filename;
  }

  public Properties read() throws IOException {
    Properties prop = new Properties();
    prop.load(new FileInputStream("resources/" + this.filename));
    return prop;
  }
}