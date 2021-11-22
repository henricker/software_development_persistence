package br.com.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quixada.dspersist.employees.domain.business.dto.CreateEmployeeInputDTO;
import br.com.quixada.dspersist.employees.domain.business.usecase.CrudEmployee;
import br.com.quixada.dspersist.employees.main.adapters.validators.CPFValidator;
import br.com.quixada.dspersist.employees.main.adapters.validators.EmailValidator;
import br.com.quixada.dspersist.employees.main.adapters.validators.RegisterValidator;
import br.com.quixada.dspersist.employees.main.ui.tui.errors.FieldsValidationException;
import br.com.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

@Service
public class CreateEmployeeTUI {
  
  @Autowired
  private EmailValidator emailValidator;

  @Autowired
  private CPFValidator cpfValidator;

  @Autowired
  private RegisterValidator registerValidator;

  @Autowired
  private CrudEmployee crudEmployee;

  public CreateEmployeeInputDTO getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Adicionar funcionário ---");
    System.out.print("Nome: ");
    String name = scanner.next();
    System.out.print("Sobrenome: ");
    String lastName = scanner.next();
    System.out.print("CPF: ");
    String cpf = scanner.next();
    System.out.print("Matrícula: ");
    String registration = scanner.next();
    System.out.print("Email: ");
    String email = scanner.next();
    System.out.print("Telefone/celular: ");
    String phone = scanner.next();

    if(!this.cpfValidator.validate(cpf))
      throw FieldsValidationException.CPFValidationError();
    
    if(!this.registerValidator.validate(registration))
      throw FieldsValidationException.registrationValidationError();

    if(!this.emailValidator.validate(email))
      throw FieldsValidationException.emailValidationError();

    return new CreateEmployeeInputDTO(cpf, registration, name + " " + lastName, email, phone);
  }

  public void run(Scanner scanner) {
    while(true) {
      CreateEmployeeInputDTO dto = this.getData(scanner);
      this.crudEmployee.create(dto);

      System.out.println("Continuar adicionando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}
