package employees.business.usecases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.employee.DeleteByIdEmployeeUseCase;
import employees.mocks.repositories.FakeEmployeeRepository;

public class DeleteByIdEmployeeUseCaseTest {
  
  @Test
  public void shouldCallFindByMethodOfRepositoryWithCorrectId() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    DeleteByIdEmployeeUseCase useCase = new DeleteByIdEmployeeUseCase(repo);

    useCase.exec("valid_id");
    Mockito.verify(repo).findBy("id", "valid_id");
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowEmployeeErrorIfEmployeeNotFound() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("id", "valid_id")).thenReturn(null);
    DeleteByIdEmployeeUseCase useCase = new DeleteByIdEmployeeUseCase(repo);

    useCase.exec("valid_id");
    Mockito.verify(repo).findBy("id", "valid_id");
  }

  @Test
  public void shouldCallDeleteByMethodOfRepositoryWithCorrectId() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    DeleteByIdEmployeeUseCase useCase = new DeleteByIdEmployeeUseCase(repo);

    useCase.exec("valid_id");
    Mockito.verify(repo).deleteBy("id", "valid_id");
  }


}
