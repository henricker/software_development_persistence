package br.quixada.dspersist.employees;

import java.sql.SQLException;

import br.quixada.dspersist.employees.data.postgres.connection.ConnectionFactory;

public class App {
    public static void main( String[] args ) throws SQLException {
        ConnectionFactory.getConnection();
    }
}
