package employees.business.usecases.employee;

import employees.business.dto.employee.UpdateEmployeeInputDTO;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateEmployeeByIdUseCase implements IUseCaseContract<UpdateEmployeeInputDTO, Void>{
  private IEmployeeRepository repository;

  @Override
  public Void exec(UpdateEmployeeInputDTO data) {
    this.repository.findBy("id", data.getId());
    return null;
  }


}
