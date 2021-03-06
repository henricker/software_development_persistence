package com.ufc.quixada.dspersist.employees.main.ui.tui;

import java.util.Scanner;

import com.ufc.quixada.dspersist.employees.main.ui.tui.options.CreateEmployeeTUI;
import com.ufc.quixada.dspersist.employees.main.ui.tui.options.DeleteEmployeeById;
import com.ufc.quixada.dspersist.employees.main.ui.tui.options.FindAllEmployeeTUI;
import com.ufc.quixada.dspersist.employees.main.ui.tui.options.FindEmployeeByCPFTUI;
import com.ufc.quixada.dspersist.employees.main.ui.tui.options.FindEmployeeByIdTUI;
import com.ufc.quixada.dspersist.employees.main.ui.tui.options.FindEmployeeByRegistrationTUI;
import com.ufc.quixada.dspersist.employees.main.ui.tui.options.UpdateEmployeeTUI;
import com.ufc.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;
import com.ufc.quixada.dspersist.employees.shared.error.BusinessException;
import com.ufc.quixada.dspersist.employees.shared.error.ServerException;
import com.ufc.quixada.dspersist.employees.shared.error.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainTUI {
  
  @Autowired
  private CreateEmployeeTUI createEmployeeTUI;

  @Autowired
  private FindEmployeeByIdTUI findEmployeeByIdTUI;

  @Autowired
  private FindEmployeeByCPFTUI findEmployeeByCPFTUI;

  @Autowired
  private FindEmployeeByRegistrationTUI findEmployeeByRegistrationTUI;

  @Autowired
  private FindAllEmployeeTUI findAllEmployeeTUI;

  @Autowired
  private DeleteEmployeeById deleteEmployeeById;

  @Autowired
  private UpdateEmployeeTUI updateEmployeeTUI;
  

  public Integer showMenu(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("----- Employee Management ------");
    System.out.println("1 - Adicionar funcionário");
    System.out.println("2 - Listar funcionários");
    System.out.println("3 - Buscar funcionário por id");
    System.out.println("4 - Buscar funcionário por CPF");
    System.out.println("5 - Buscar funcionário por matrícula");
    System.out.println("6 - Deletar funcionário");
    System.out.println("7 - Atualizar funcionário");
    System.out.println("0 - Sair");
    System.out.print("Sua opção: ");
    return scanner.nextInt();
  }

  public void run(Scanner scanner) {
    try {
      Boolean keepOnSystem = true;
      while(Boolean.TRUE.equals(keepOnSystem)) {
        Integer option = this.showMenu(scanner);
  
        if(option == 0)
          break;
  
        else if(option == 2) 
          this.findAllEmployeeTUI.run(scanner);
  
        else if(option == 1)
          this.createEmployeeTUI.run(scanner);
  
        else if(option == 3)
          this.findEmployeeByIdTUI.run(scanner);
  
        else if(option == 4)
          this.findEmployeeByCPFTUI.run(scanner);
  
        else if(option == 5)
          this.findEmployeeByRegistrationTUI.run(scanner);
  
        else if(option == 6)
          this.deleteEmployeeById.run(scanner);
  
        else if(option == 7)
          this.updateEmployeeTUI.run(scanner);
  
        else
          System.out.println("Opção inválida!");
      }
      scanner.close();
    } catch(BusinessException be) {
      TUIUtil.clearScreen();
      System.out.println(be.getBodyError());
      System.out.println("Digite qualquer tecla para continuar: ");
      scanner.next();
      run(scanner);
    } catch(ValidationException ve) {
      TUIUtil.clearScreen();
      System.out.println(ve.getBodyError());
      System.out.println("Digite qualquer tecla para continuar: ");
      scanner.next();
      run(scanner);
    } catch(Exception err) {
      TUIUtil.clearScreen();
      System.out.println(new ServerException("Oops!, Ocorreu um erro no servidor!").getBodyError());
      System.out.println("Digite qualquer tecla para continuar: ");
      System.out.println(err);
      scanner.next();
      run(scanner);
    }
    
  }
}