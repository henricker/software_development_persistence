package com.ufc.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Optional;
import java.util.Scanner;

import com.ufc.quixada.dspersist.employees.domain.business.services.CRUDEmployee;
import com.ufc.quixada.dspersist.employees.domain.entities.Employee;
import com.ufc.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindEmployeeByCPFTUI {
  @Autowired
  private CRUDEmployee crudEmployee;

  public String getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Pesquisar funcionário por CPF ---");
    System.out.print("CPF: ");
    return scanner.next();
  }

  public void run(Scanner scanner) {
    while(true) {
      String cpf = this.getData(scanner);
      Optional<Employee> employee = this.crudEmployee.findByCPF(cpf);
      TUIUtil.clearScreen();
      
      if(!employee.isPresent())
        System.out.println("Funcionário não encontrado!");
      else
        System.out.println(employee.get());

      System.out.println("Continuar pesquisando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}