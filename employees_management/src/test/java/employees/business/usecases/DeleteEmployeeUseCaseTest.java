package employees.business.usecases;

import org.junit.Test;
import org.mockito.Mockito;

import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.employee.DeleteByIdEmployeeUseCase;
import employees.mocks.repositories.FakeEmployeeRepository;

public class DeleteEmployeeUseCaseTest {
  
  @Test
  public void shouldCallDeleteByMethodOfRepositoryWithCorrectIdAndValueId() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    DeleteByIdEmployeeUseCase useCase = new DeleteByIdEmployeeUseCase(repo);

    useCase.exec("eqwe123-wqe123we34-123412");
    Mockito.verify(repo).findBy("id", "eqwe123-wqe123we34-123412");
  }

}
