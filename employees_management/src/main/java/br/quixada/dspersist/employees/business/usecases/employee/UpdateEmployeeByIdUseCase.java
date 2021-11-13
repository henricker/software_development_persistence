package br.quixada.dspersist.employees.business.usecases.employee;

import br.quixada.dspersist.employees.business.dto.employee.UpdateEmployeeInputDTO;
import br.quixada.dspersist.employees.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.business.usecases.IUseCaseContract;
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
    
    this.repository.updateBy("id", data.getId(), data.map());

    return null;
  }


}
