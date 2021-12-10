package com.ufc.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Optional;
import java.util.Scanner;

import com.ufc.quixada.dspersist.employees.domain.business.services.CRUDEmployee;
import com.ufc.quixada.dspersist.employees.domain.entities.Employee;
import com.ufc.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindEmployeeByIdTUI {
  @Autowired
  private CRUDEmployee crudEmployee;

  public Integer getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Pesquisar funcionário por id ---");
    System.out.print("id: ");
    return scanner.nextInt();
  }

  public void run(Scanner scanner) {
    while(true) {
      Integer id = this.getData(scanner);
      Optional<Employee> employee = this.crudEmployee.findById(id);
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
