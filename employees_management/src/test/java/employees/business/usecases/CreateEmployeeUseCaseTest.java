package employees.business.usecases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import employees.business.dto.employee.CreateEmployeeInputDTO;
import employees.business.module.errors.employee.EmployeeErrors;
import employees.business.repositories.IEmployeeRepository;
import employees.business.usecases.employee.CreateEmployeeUseCase;
import employees.domain.entities.Employee;
import employees.mocks.dto.employee.FakeEmployeeDTOFactory;
import employees.mocks.repositories.FakeEmployeeRepository;


public class CreateEmployeeUseCaseTest {


  @Test
  public void shouldCallFindbyMethodOfRepositoryWithCPFandValueCPF() {
      IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
      when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
      when(repo.findBy("registration", "valid_registration")).thenReturn(null);
      CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo);
  
      useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  
      Mockito.verify(repo).findBy("cpf", "valid_cpf");  
  }

  @Test
  public void shouldCallFindbyMethodOfRepositoryWithRegistrationandValueRegistration() {
      IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
      when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
      when(repo.findBy("registration", "valid_registration")).thenReturn(null);
      CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo);
  
      useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  
      Mockito.verify(repo).findBy("registration", "valid_registration");  
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowsIfCpfAlreadyInUse() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo);

    useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  }

  @Test(expected = EmployeeErrors.class)
  public void shouldThrowsIfRegistrationAlreadyInUse() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo);

    useCase.exec(FakeEmployeeDTOFactory.createEmployeeInput());
  }

  @Test()
  public void shouldCallCreateMethodOfRepositoryWithCorrectValues() {
    IEmployeeRepository repo = Mockito.spy(new FakeEmployeeRepository());
    when(repo.findBy("cpf", "valid_cpf")).thenReturn(null);
    when(repo.findBy("registration", "valid_registration")).thenReturn(null);
    CreateEmployeeUseCase useCase = new CreateEmployeeUseCase(repo);

    CreateEmployeeInputDTO inputCreateEmployee = FakeEmployeeDTOFactory.createEmployeeInput();
    useCase.exec(inputCreateEmployee);

    Mockito.verify(repo).create(new Employee(
      inputCreateEmployee.getCpf(),
      inputCreateEmployee.getRegistration(),
      inputCreateEmployee.getName(),
      inputCreateEmployee.getEmail(),
      inputCreateEmployee.getPhone()
    ));
  }
 
}
