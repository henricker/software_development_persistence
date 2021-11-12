package employees.business.usecases.employee;

import employees.business.dto.employee.UpdateEmployeeInputDTO;
import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;
import employees.domain.entities.Employee;
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

    Boolean registrationExists = this.repository.findBy("registration", "valid_registration") != null;
    
    if(registrationExists)
      throw EmployeeErrors.registrationAlreadyExistsError();
    
    Employee employee = new Employee(
      data.getId(),
      data.getCpf(),
      data.getRegistration(),
      data.getName(),
      data.getEmail(),
      data.getPhone()
    );

    this.repository.updateBy("id", data.getId(), employee);

    return null;
  }


}
