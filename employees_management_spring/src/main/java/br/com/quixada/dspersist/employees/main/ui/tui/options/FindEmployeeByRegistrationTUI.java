package br.com.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quixada.dspersist.employees.domain.business.usecase.CrudEmployee;
import br.com.quixada.dspersist.employees.domain.entities.Employee;
import br.com.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

@Service
public class FindEmployeeByRegistrationTUI {
  @Autowired
  private CrudEmployee crudEmployee;

  public String getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Pesquisar funcionário por matrícula ---");
    System.out.print("matrícula: ");
    return scanner.next();
  }

  public void run(Scanner scanner) {
    while(true) {
      String registration = this.getData(scanner);
      Employee employee = this.crudEmployee.findByRegistration(registration);
     
      if(employee == null)
        System.out.println("Funcionário não encontrado!");
      else
        System.out.println(employee);
        
      System.out.println("Continuar pesquisando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}
