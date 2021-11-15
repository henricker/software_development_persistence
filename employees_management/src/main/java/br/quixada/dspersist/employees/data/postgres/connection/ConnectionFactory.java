package br.quixada.dspersist.employees.data.postgres.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.quixada.dspersist.employees.data.postgres.config.DatabaseProps;
import br.quixada.dspersist.employees.shared.Error.ServerError;

public class ConnectionFactory {

  public static Connection getConnection() {
    try {
        Connection con = DriverManager.getConnection(
        DatabaseProps.PROPS.getProperty("database.url"),
        DatabaseProps.PROPS.getProperty("database.user"),
        DatabaseProps.PROPS.getProperty("database.password")  
      );

      return con;
    } catch(SQLException err) {
      throw ServerError.serverError();
    }


  }
  
}
