package employees.business.repositories;

import employees.domain.entities.Employee;

public interface IEmployeeRepository {
  public void create(Employee employee);
  public Employee findBy(String uniqueKey, String value);
  public void update(String uniqueKey, Employee employee);
  public void deleteBy(String uniqueKey, String value);
}
