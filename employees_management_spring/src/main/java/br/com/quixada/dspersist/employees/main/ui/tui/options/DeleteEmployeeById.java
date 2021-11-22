package br.com.quixada.dspersist.employees.main.ui.tui.options;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quixada.dspersist.employees.domain.business.usecase.CrudEmployee;
import br.com.quixada.dspersist.employees.main.ui.tui.util.TUIUtil;

@Service
public class DeleteEmployeeById {
  @Autowired
  private CrudEmployee crudEmployee;

  public String getData(Scanner scanner) {
    TUIUtil.clearScreen();
    System.out.println("--- Deletar funcionário ---");
    System.out.print("id: ");
    return scanner.next();
  }

  public void run(Scanner scanner) {
    while(true) {
      String id = this.getData(scanner);
      this.crudEmployee.delete(id);
      System.out.println("Funcionário deletado com sucesso!");
      System.out.println("Continuar pesquisando funcionários? < 0 para sair | qualquer tecla para continuar >");
      Integer option = scanner.nextInt();

      if(option == 0)
        break;
    }
  }
}
