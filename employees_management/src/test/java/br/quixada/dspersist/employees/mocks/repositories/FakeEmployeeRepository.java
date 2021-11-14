package br.quixada.dspersist.employees.mocks.repositories;

import java.util.ArrayList;
import java.util.List;

import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.entities.Employee;

public class FakeEmployeeRepository implements IEmployeeRepository {

  @Override
  public void create(Employee employee) {}

  @Override
  public Employee findBy(String uniqueKey, Object value) {
    return new Employee("qew67qw5e-123qsdqe-2312dqsd", "00000000000", "123212", "Henricker Vieira", "email@valid.com", "88988888888");
  }

  @Override
  public void updateBy(String uniqueKey, Object valueUniqueKey, Employee employee) {}

  @Override
  public void deleteBy(String uniqueKey, Object value) {}

  @Override
  public List<Employee> findAll(Integer page, Integer limit) {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee("qew67qw5e-123qsdqe-2312dqsd", "00000000000", "123212", "Henricker Vieira", "email@valid.com", "88988888888"));
    return list;
  }
  
}
