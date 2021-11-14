package br.quixada.dspersist.employees;

import java.sql.Connection;
import java.sql.SQLException;

import br.quixada.dspersist.employees.data.postgres.connection.ConnectionFactory;
import br.quixada.dspersist.employees.data.postgres.repositories.EmployeeRepositoryJDBCPostgres;
import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.entities.Employee;

public class App {
    public static void main( String[] args ) throws SQLException {
        try {
            Connection connection = ConnectionFactory.getConnection();
            EmployeeRepositoryJDBCPostgres repository = new EmployeeRepositoryJDBCPostgres(connection);

            Employee employee = new Employee();
            employee.setCpf("11111111111");
            employee.setEmail("valid@valid.com");
            employee.setName("Henrique Vieira");
            employee.setPhone("00900000011");
            employee.setRegistration("494229");

            repository.updateBy("cpf", "11111111111", employee);
        } catch(EmployeeErrors err) {
            System.out.println(err.getBody().getShortMessage());
        }
    }
}
