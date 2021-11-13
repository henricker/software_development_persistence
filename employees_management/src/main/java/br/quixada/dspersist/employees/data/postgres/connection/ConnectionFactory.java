package br.quixada.dspersist.employees.data.postgres.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.quixada.dspersist.employees.data.postgres.config.DatabaseProps;

public class ConnectionFactory {

  public static Connection getConnection() throws SQLException {
    Connection con = DriverManager.getConnection(
      DatabaseProps.PROPS.getProperty("database.url"),
      DatabaseProps.PROPS.getProperty("database.user"),
      DatabaseProps.PROPS.getProperty("database.password")  
    );

    return con;
  }
  
}
