package com.ufc.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Scanner;

import com.ufc.quixada.dspersist.employees.domain.business.dto.CreateEmployeeInputDTO;
import com.ufc.quixada.dspersist.employees.domain.business.services.CRUDEmployee;
import com.ufc.quixada.dspersist.employees.main.adapters.validators.CPFValidator;
import com.ufc.quixada.dspersist.employees.main.adapters.validators.EmailValidator;
import com.ufc.quixada.dspersist.employees.main.adapters.validators.RegisterValidator;
import com.ufc.quixada.dspersist.employees.main.ui.tui.errors.FieldsValidationException;
import com.ufc.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployeeTUI {
  
  @Autowired
  private EmailValidator emailValidator;

  @Autowired
  private CPFValidator cpfValidator;

  @Autowired
  private RegisterValidator registerValidator;

  @Autowired
  private CRUDEmployee crudEmployee;

  public CreateEmployeeInputDTO getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println( "--- Adicionar funcionário ---");
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

    if(Boolean.FALSE.equals(this.cpfValidator.validate(cpf)))
      throw FieldsValidationException.cpfvalidationError();
    
    if(Boolean.FALSE.equals(this.registerValidator.validate(registration)))
      throw FieldsValidationException.registrationValidationError();

    if(Boolean.FALSE.equals(this.emailValidator.validate(email)))
      throw FieldsValidationException.emailValidationError();

    return new CreateEmployeeInputDTO(cpf, registration, name + " " + lastName, email, phone);
  }

  public void run(Scanner scanner) {
    while(true) {
      CreateEmployeeInputDTO dto = this.getData(scanner);
      this.crudEmployee.create(dto);
      TUIUtil.clearScreen();
      
      System.out.println("Continuar adicionando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}