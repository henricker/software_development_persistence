package com.ufc.quixada.dspersist.employees.main.ui.tui.options;

import java.util.List;
import java.util.Scanner;

import com.ufc.quixada.dspersist.employees.domain.business.dto.ListEmployeeInputDTO;
import com.ufc.quixada.dspersist.employees.domain.business.services.CRUDEmployee;
import com.ufc.quixada.dspersist.employees.domain.entities.Employee;
import com.ufc.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindAllEmployeeTUI {
  @Autowired
  private CRUDEmployee crudEmployee;

  public ListEmployeeInputDTO getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Listar funcionários ---");
    System.out.print("Página: ");
    Integer page = scanner.nextInt();
    System.out.print("Limite: ");
    Integer limit = scanner.nextInt();

    return new ListEmployeeInputDTO(page, limit);
  }

  public void run(Scanner scanner) {
    while(true) {
      ListEmployeeInputDTO data = this.getData(scanner);
      List<Employee> employees = this.crudEmployee.findAll(data);
      TUIUtil.clearScreen();
      
      if(employees.isEmpty())
        System.out.println("[]");
      else
        employees.forEach(System.out::println);

      System.out.println("Continuar pesquisando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}