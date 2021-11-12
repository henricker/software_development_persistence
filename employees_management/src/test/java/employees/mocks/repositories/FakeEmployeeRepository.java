package employees.mocks.repositories;

import employees.business.repositories.IEmployeeRepository;
import employees.domain.entities.Employee;

public class FakeEmployeeRepository implements IEmployeeRepository {

  @Override
  public void create(Employee employee) {}

  @Override
  public Employee findBy(String uniqueKey, String value) {
    return new Employee("qew67qw5e-123qsdqe-2312dqsd", "00000000000", "123212", "Henricker Vieira", "email@valid.com", "88988888888");
  }

  @Override
  public void update(String uniqueKey, Employee employee) {}

  @Override
  public void deleteBy(String uniqueKey, String value) {}
  
}
