package employees.business.usecases.employee;

import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;

public class DeleteByIdEmployeeUseCase implements IUseCaseContract<String, Void> {

  private IEmployeeRepository repository;
  public DeleteByIdEmployeeUseCase(IEmployeeRepository repository) {
    this.repository = repository;
  }

  @Override
  public Void exec(String id) {
    Boolean employeeExists = this.repository.findBy("id", id) != null ? true : false;

    if(!employeeExists)
      throw EmployeeErrors.employeeNotFoundError();

    return null;
  }
  
}
