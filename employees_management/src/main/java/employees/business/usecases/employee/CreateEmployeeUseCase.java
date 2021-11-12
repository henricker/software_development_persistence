package employees.business.usecases.employee;

import employees.business.dto.employee.CreateEmployeeInputDTO;
import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;
import employees.domain.entities.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateEmployeeUseCase implements IUseCaseContract<CreateEmployeeInputDTO, Void> {
  private IEmployeeRepository employeeRepository;

  @Override
  public Void exec(CreateEmployeeInputDTO data) {
    
    Boolean cpfExists = this.employeeRepository.findBy("cpf", data.getCpf()) != null;

    if(cpfExists)
      throw EmployeeErrors.cpfAlreadyExistsError();

    return null;
  }
}
