package br.quixada.dspersist.employees.main.factories;

import java.sql.Connection;
import br.quixada.dspersist.employees.data.postgres.repositories.EmployeeRepositoryJDBCPostgres;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.services.uniqueIndentifier.IUniqueIndentifier;
import br.quixada.dspersist.employees.domain.business.usecases.employee.CreateEmployeeUseCase;
import br.quixada.dspersist.employees.main.adapters.UniqueIndentifierAdapter;

public class CreateEmployeeUseCaseFactory {
  public static CreateEmployeeUseCase factory(Connection connection) {
    IEmployeeRepository repository = new EmployeeRepositoryJDBCPostgres(connection);
    IUniqueIndentifier uniqueIndentifierService = new UniqueIndentifierAdapter();
    return new CreateEmployeeUseCase(repository, uniqueIndentifierService);
  }
}
