package br.quixada.dspersist.employees.business.usecases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import br.quixada.dspersist.employees.domain.business.dto.employee.UpdateEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.usecases.employee.UpdateEmployeeByIdUseCase;
import br.quixada.dspersist.employees.mocks.dto.employee.FakeEmployeeDTOFactory;
import br.quixada.dspersist.employees.mocks.repositories.FakeEmployeeRepository;

public class UpdateEmployeeByIdUseCaseTest {
  
  @Test
  public void shouldCallFindByMethodOfRepositoryWithCorrectId() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);

    useCase.exec(
      new UpdateEmployeeInputDTO(
        "valid_id",
        "valid_cpf",
        "valid_registration", 
        "valid_name", 
        "valid_email", 
        "valid_phone"
      )
    );

    Mockito.verify(repo).findBy("id", "valid_id");
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldReturnEmployeeErrorIfEmployeeNotFoundWithId() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("id", "valid_id")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.updateEmployeeInput());
  }

  @Test
  public void shouldCallFindByMethodOfRepositoryWithCorrectCpf() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.updateEmployeeInput());
    Mockito.verify(repo).findBy("cpf", "valid_cpf");
  }


  @Test(expected = EmployeeErrors.class)
  public void shouldThrowEmployeeErrorIfCpfAlreadyExists() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.updateEmployeeInput());
  }

  @Test
  public void shouldCallFindByMethodOfRepositoryWithCorrectRegistration() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.updateEmployeeInput());
    Mockito.verify(repo).findBy("cpf", "valid_cpf");
  }


  @Test(expected = EmployeeErrors.class)
  public void shouldThrowEmployeeErrorIfRegistrationAlreadyExists() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.updateEmployeeInput());
  }

  @Test
  public void shouldCallUpdateByOfRepositoryWithCorrectValues() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    UpdateEmployeeByIdUseCase useCase = new UpdateEmployeeByIdUseCase(repo);
    useCase.exec(FakeEmployeeDTOFactory.updateEmployeeInput());


    Mockito.verify(repo).updateBy(
      "id", 
      "valid_id", 
      FakeEmployeeDTOFactory.updateEmployeeInput().map()
    );
  }

}
