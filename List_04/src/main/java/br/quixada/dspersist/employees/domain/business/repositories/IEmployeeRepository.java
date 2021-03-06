package br.quixada.dspersist.employees.domain.business.repositories;

import java.util.List;

import br.quixada.dspersist.employees.domain.entities.Employee;

public interface IEmployeeRepository {
  public void create(Employee employee);
  public Employee findBy(String uniqueKey, Object value);
  public void updateBy(String uniqueKey, Object valueUniqueKey, Employee employee);
  public List<Employee> findAll(Integer page, Integer limit);
  public void deleteBy(String uniqueKey, Object value);
}
