package com.ufc.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Scanner;

import com.ufc.quixada.dspersist.employees.domain.business.dto.UpdateEmployeeInputDTO;
import com.ufc.quixada.dspersist.employees.domain.business.services.CRUDEmployee;
import com.ufc.quixada.dspersist.employees.main.adapters.validators.CPFValidator;
import com.ufc.quixada.dspersist.employees.main.adapters.validators.EmailValidator;
import com.ufc.quixada.dspersist.employees.main.adapters.validators.RegisterValidator;
import com.ufc.quixada.dspersist.employees.main.ui.tui.errors.FieldsValidationException;
import com.ufc.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeTUI {
  
  @Autowired
  private EmailValidator emailValidator;

  @Autowired
  private CPFValidator cpfValidator;

  @Autowired
  private RegisterValidator registerValidator;

  @Autowired
  private CRUDEmployee crudEmployee;

  public UpdateEmployeeInputDTO getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Atualizar funcionário ---");
    System.out.print("id: ");
    Integer id = scanner.nextInt();
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

    if(Boolean.FALSE.equals(this.cpfValidator.validate(cpf)))
      throw FieldsValidationException.cpfvalidationError();
  
    if(Boolean.FALSE.equals(this.registerValidator.validate(registration)))
      throw FieldsValidationException.registrationValidationError();

    if(Boolean.FALSE.equals(this.emailValidator.validate(email)))
      throw FieldsValidationException.emailValidationError();
    
    return new UpdateEmployeeInputDTO(id, cpf, registration, name + " " + lastname, email, phone);
  }

  public void run(Scanner scanner) {
    while(true) {
      UpdateEmployeeInputDTO data = this.getData(scanner);
      this.crudEmployee.update(data);
      TUIUtil.clearScreen();
      
      System.out.println("Funcionário atualizado com sucesso!");        
      System.out.println("Continuar pesquisando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}
