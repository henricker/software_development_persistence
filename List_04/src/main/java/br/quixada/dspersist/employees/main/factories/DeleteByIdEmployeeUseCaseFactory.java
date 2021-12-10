package br.quixada.dspersist.employees.main.factories;

import java.sql.Connection;

import br.quixada.dspersist.employees.data.postgres.repositories.EmployeeRepositoryJDBCPostgres;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.usecases.employee.DeleteByIdEmployeeUseCase;

public class DeleteByIdEmployeeUseCaseFactory {
  public static DeleteByIdEmployeeUseCase factory(Connection connection) {
    IEmployeeRepository repository = new EmployeeRepositoryJDBCPostgres(connection);
    return new DeleteByIdEmployeeUseCase(repository);
  }
}
