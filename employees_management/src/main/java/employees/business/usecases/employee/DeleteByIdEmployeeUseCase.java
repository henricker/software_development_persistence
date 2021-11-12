package employees.business.usecases.employee;

import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;

public class DeleteByIdEmployeeUseCase implements IUseCaseContract<String, Void> {

  private IEmployeeRepository repository;
  public DeleteByIdEmployeeUseCase(IEmployeeRepository repository) {
    this.repository = repository;
  }

  @Override
  public Void exec(String id) {
    this.repository.findBy("id", id);
    return null;
  }
  
}
