package employees.business.usecases.employee;

import employees.business.dto.employee.UpdateEmployeeInputDTO;
import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateEmployeeByIdUseCase implements IUseCaseContract<UpdateEmployeeInputDTO, Void>{
  private IEmployeeRepository repository;

  @Override
  public Void exec(UpdateEmployeeInputDTO data) {
    Boolean employeeExists = this.repository.findBy("id", data.getId()) != null;

    if(!employeeExists)
      throw EmployeeErrors.employeeNotFoundError();

    Boolean cpfExists = this.repository.findBy("cpf", data.getCpf()) != null;

    if(cpfExists)
      throw EmployeeErrors.cpfAlreadyExistsError();

    return null;
  }


}
