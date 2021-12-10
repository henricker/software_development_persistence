package br.com.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quixada.dspersist.employees.domain.business.dto.UpdateEmployeeInputDTO;
import br.com.quixada.dspersist.employees.domain.business.usecase.CrudEmployee;
import br.com.quixada.dspersist.employees.main.adapters.validators.CPFValidator;
import br.com.quixada.dspersist.employees.main.adapters.validators.EmailValidator;
import br.com.quixada.dspersist.employees.main.adapters.validators.RegisterValidator;
import br.com.quixada.dspersist.employees.main.ui.tui.errors.FieldsValidationException;
import br.com.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

@Service
public class UpdateEmployeeTUI {

  @Autowired
  private EmailValidator emailValidator;

  @Autowired
  private CPFValidator cpfValidator;

  @Autowired
  private RegisterValidator registerValidator;

  @Autowired
  private CrudEmployee crudEmployee;

  public UpdateEmployeeInputDTO getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Atualizar funcionário ---");
    System.out.print("id: ");
    String id = scanner.next();
    System.out.println("---- dados para atualizar ----");
    System.out.print("Nome: ");
    String name = scanner.next();
    System.out.print("Sobrenome: ");
    String lastname = scanner.next();
    System.out.print("Email: ");
    String email = scanner.next();
    System.out.print("Telefone/celular: ");
    String phone = scanner.next();
    System.out.print("CPF: ");
    String cpf = scanner.next();
    System.out.print("registration: ");
    String registration = scanner.next();

    if(!this.cpfValidator.validate(cpf))
      throw FieldsValidationException.CPFValidationError();
  
    if(!this.registerValidator.validate(registration))
      throw FieldsValidationException.registrationValidationError();

    if(!this.emailValidator.validate(email))
      throw FieldsValidationException.emailValidationError();
    
    return new UpdateEmployeeInputDTO(id, cpf, registration, name + " " + lastname, email, phone);
  }

  public void run(Scanner scanner) {
    while(true) {
      UpdateEmployeeInputDTO data = this.getData(scanner);
      this.crudEmployee.update(data);
     
      System.out.println("Funcionário atualizado com sucesso!");        
      System.out.println("Continuar pesquisando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}
