package employees.business.usecases.employee;

import java.util.List;

import employees.business.dto.employee.ListEmployeeInputDTO;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.IUseCaseContract;

import employees.domain.entities.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListEmployeesUseCase implements IUseCaseContract<ListEmployeeInputDTO, List<Employee>> {

  private IEmployeeRepository repository;

  @Override
  public List<Employee> exec(ListEmployeeInputDTO options) {
    this.repository.findAll(options.getPage(), options.getLimit());
    return null;
  }

}
