package employees.business.usecases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.employee.ListEmployeesUseCase;
import employees.domain.entities.Employee;
import employees.mocks.dto.employee.FakeEmployeeDTOFactory;
import employees.mocks.repositories.FakeEmployeeRepository;

public class ListEmployeesUseCaseTest {
  
  @Test
  public void shouldCallFindAllMethofOfRepositoryWithCorrectPaginationValues() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    ListEmployeesUseCase useCase = new ListEmployeesUseCase(repo);

    useCase.exec(FakeEmployeeDTOFactory.listEmployeeInput());

    Mockito.verify(repo).findAll(0, 10);
  }

  @Test
  public void shouldReturnAListWithEmployees() {
    ListEmployeesUseCase useCase = new ListEmployeesUseCase(new FakeEmployeeRepository());
    List<Employee> employees = useCase.exec(FakeEmployeeDTOFactory.listEmployeeInput());
    
    assertEquals(employees, new FakeEmployeeRepository().findAll(0, 10));
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowErrorIfRepositoryThrows() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findAll(0, 10)).thenThrow(EmployeeErrors.employeeListError());
    ListEmployeesUseCase useCase = new ListEmployeesUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.listEmployeeInput());
  }

}
