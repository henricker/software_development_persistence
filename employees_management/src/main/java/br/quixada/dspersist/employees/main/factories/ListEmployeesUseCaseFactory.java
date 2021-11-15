package br.quixada.dspersist.employees.main.factories;

import java.sql.Connection;

import br.quixada.dspersist.employees.data.postgres.repositories.EmployeeRepositoryJDBCPostgres;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.usecases.employee.ListEmployeesUseCase;

public class ListEmployeesUseCaseFactory {
  public static ListEmployeesUseCase factory(Connection connection) {
    IEmployeeRepository repository = new EmployeeRepositoryJDBCPostgres(connection);
    return new ListEmployeesUseCase(repository);
  }
}
