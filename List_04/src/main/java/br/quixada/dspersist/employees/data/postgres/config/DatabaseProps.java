package br.quixada.dspersist.employees.data.postgres.config;

import java.io.FileInputStream;
import java.util.Properties;

public class DatabaseProps {
  public static Properties PROPS = null;

  static {
    try {
      Properties props = new Properties();
      props.load(new FileInputStream("src/main/resources/config.properties"));
      PROPS = props;
    } catch(Exception e) { 
      e.printStackTrace();
    }
  }
}
