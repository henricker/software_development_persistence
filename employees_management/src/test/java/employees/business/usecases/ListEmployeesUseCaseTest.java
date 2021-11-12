package employees.business.usecases;

import org.junit.Test;
import org.mockito.Mockito;

import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.employee.ListEmployeesUseCase;
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

}
