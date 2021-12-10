package br.quixada.dspersist.employees.business.usecases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import br.quixada.dspersist.employees.domain.business.dto.employee.CreateEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.business.services.uniqueIndentifier.IUniqueIndentifier;
import br.quixada.dspersist.employees.domain.business.usecases.employee.CreateEmployeeUseCase;
import br.quixada.dspersist.employees.domain.entities.Employee;
import br.quixada.dspersist.employees.mocks.dto.employee.FakeEmployeeDTOFactory;
import br.quixada.dspersist.employees.mocks.repositories.FakeEmployeeRepository;
import br.quixada.dspersist.employees.mocks.services.FakeUniqueIndentifier;


public class CreateEmployeeUseCaseTest {


  @Test
  public void shouldCallFindbyMethodOfRepositoryWithCPFandValueCPF() {
      IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
      IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
      when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
      when(repo.findBy("registration", "valid_registration")).thenReturn(null);
      CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);
  
      useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  
      Mockito.verify(repo).findBy("cpf", "valid_cpf");  
  }

  @Test
  public void shouldCallFindbyMethodOfRepositoryWithRegistrationandValueRegistration() {
      IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
      IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
      when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
      when(repo.findBy("registration", "valid_registration")).thenReturn(null);
      CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);
  
      useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  
      Mockito.verify(repo).findBy("registration", "valid_registration");  
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowsIfCpfAlreadyInUse() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);

    useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowsIfRegistrationAlreadyInUse() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);

    useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  }

  @Test
  public void shouldCallCreateMethodOfRepositoryWithCorrectValues() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);

    CreateEmployeeInputDTO inputCreateEmployee = FakeEmployeeDTOFactory.createEmployeeInput();
    useCase.exec(inputCreateEmployee);

    Mockito.verify(repo).create(new Employee(
      uuidService.create(),  
      inputCreateEmployee.getCpf(),
      inputCreateEmployee.getRegistration(),
      inputCreateEmployee.getName(),
      inputCreateEmployee.getEmail(),
      inputCreateEmployee.getPhone()
    ));
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowErrorIfRepositoryThrows() {
      IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
      IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
      when(repo.findBy("cpf", "valid_cpf")).thenThrow(EmployeeErrors.employeeCreationError());
      CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);

      useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  }

  @Test
  public void shouldCallsUniqueIndentifierService() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    IUniqueIndentifier uuidService = Mockito.spy(new FakeUniqueIndentifier());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo, uuidService);

    useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());

    Mockito.verify(uuidService).create();  
  }
}
