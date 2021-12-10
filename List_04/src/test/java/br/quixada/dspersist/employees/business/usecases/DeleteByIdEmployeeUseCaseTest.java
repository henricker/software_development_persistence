package br.quixada.dspersist.employees.business.usecases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.usecases.employee.DeleteByIdEmployeeUseCase;
import br.quixada.dspersist.employees.mocks.repositories.FakeEmployeeRepository;

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
