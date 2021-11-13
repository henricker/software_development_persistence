package br.quixada.dspersist.employees.business.usecases.employee;

import java.util.List;

import br.quixada.dspersist.employees.business.dto.employee.ListEmployeeInputDTO;
import br.quixada.dspersist.employees.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.business.usecases.IUseCaseContract;
import br.quixada.dspersist.employees.domain.entities.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListEmployeesUseCase implements IUseCaseContract<ListEmployeeInputDTO, List<Employee>> {

  private IEmployeeRepository repository;

  @Override
  public List<Employee> exec(ListEmployeeInputDTO options) {
    List<Employee> employees = this.repository.findAll(options.getPage(), options.getLimit());
    return employees;
  }

}
