package br.quixada.dspersist.employees.domain.business.usecases.employee;

import br.quixada.dspersist.employees.domain.business.dto.employee.UpdateEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.usecases.IUseCaseContract;
import br.quixada.dspersist.employees.domain.entities.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateEmployeeByIdUseCase implements IUseCaseContract<UpdateEmployeeInputDTO, Void>{
  private IEmployeeRepository repository;

  @Override
  public Void exec(UpdateEmployeeInputDTO data) {
    Boolean employeeExists = this.repository.findBy("id", data.getId()) != null;

    if(!employeeExists)
      throw EmployeeErrors.employeeNotFoundError();

    Employee employeeByCpf = this.repository.findBy("cpf", data.getCpf());
    Boolean cpfExists = employeeByCpf == null;

    if(cpfExists && !(employeeByCpf.getId().equals(data.getId())))
      throw EmployeeErrors.cpfAlreadyExistsError();

    Employee employeeByRegistration = this.repository.findBy("registration", data.getRegistration());
    Boolean registrationExists = employeeByRegistration != null;
    
    if(registrationExists && !(employeeByRegistration.getId().equals(data.getId())))
      throw EmployeeErrors.registrationAlreadyExistsError();
    
    this.repository.updateBy("id", data.getId(), data.map());

    return null;
  }


}
