package employees.business.usecases.employee;

import employees.business.dto.employee.CreateEmployeeInputDTO;
import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateEmployeeUseCase implements IUseCaseContract<CreateEmployeeInputDTO, Void> {
  private IEmployeeRepository employeeRepository;

  @Override
  public Void exec(CreateEmployeeInputDTO data) {
    
    Boolean cpfExists = this.employeeRepository.findBy("cpf", data.getCpf()) != null;

    if(cpfExists)
      throw EmployeeErrors.cpfAlreadyExistsError();

    Boolean registrationExists = this.employeeRepository.findBy("registration", data.getRegistration()) != null;
    
    if(registrationExists)
      throw EmployeeErrors.registrationAlreadyExistsError();


    this.employeeRepository.create(data.map());
      
    return null;
  }
}
