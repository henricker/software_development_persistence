package br.quixada.dspersist.employees.business.usecases.employee;

import br.quixada.dspersist.employees.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.business.usecases.IUseCaseContract;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteByIdEmployeeUseCase implements IUseCaseContract<String, Void> {

  private IEmployeeRepository repository;

  @Override
  public Void exec(String id) {
    Boolean employeeExists = this.repository.findBy("id", id) != null ? true : false;

    if(!employeeExists)
      throw EmployeeErrors.employeeNotFoundError();

    this.repository.deleteBy("id", id);

    return null;
  }
  
}
