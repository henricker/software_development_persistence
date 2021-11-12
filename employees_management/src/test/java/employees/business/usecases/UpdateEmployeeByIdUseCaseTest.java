package employees.business.usecases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import employees.business.dto.employee.UpdateEmployeeInputDTO;
import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.employee.UpdateEmployeeByIdUseCase;
import employees.mocks.repositories.FakeEmployeeRepository;

public class UpdateEmployeeByIdUseCaseTest {
  
  @Test
  public void shouldCallFindByMethodOfRepositoryWithCorrectId() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);

    useCase.exec(
      new UpdateEmployeeInputDTO(
        "valid_id", 
        "valid_registration", 
        "valid_name", 
        "valid_email", 
        "valid_phone"
      )
    );

    Mockito.verify(repo).findBy("id", "valid_id");
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldReturnEmployeeErrorIfEmployeeNotFound() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("id", "valid_id")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);

    useCase.exec(
      new UpdateEmployeeInputDTO(
        "valid_id", 
        "valid_registration", 
        "valid_name", 
        "valid_email", 
        "valid_phone"
      )
    );
  }

}
