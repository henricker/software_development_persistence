package br.quixada.dspersist.employees.main.ui.tui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import br.quixada.dspersist.employees.data.postgres.connection.ConnectionFactory;
import br.quixada.dspersist.employees.domain.business.dto.employee.CreateEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.dto.employee.ListEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.dto.employee.UpdateEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.entities.Employee;
import br.quixada.dspersist.employees.main.factories.CreateEmployeeUseCaseFactory;
import br.quixada.dspersist.employees.main.factories.DeleteByIdEmployeeUseCaseFactory;
import br.quixada.dspersist.employees.main.factories.ListEmployeesUseCaseFactory;
import br.quixada.dspersist.employees.main.factories.UpdateByIdEmployeeUseCaseFactory;
import br.quixada.dspersist.employees.shared.Error.BadError;
import br.quixada.dspersist.employees.shared.Error.Error;

public class Main {
  private static Connection connection = null;
  private static List<String> options = new ArrayList<>(Arrays.asList("create", "listAll", "delete", "update"));

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static Integer showMainMenu(Scanner scanner) {
    System.out.println("----------------------");
    System.out.println(" Employee Management  ");
    System.out.println("----------------------");
    for(int i = 0; i < Main.options.size(); i++)
      System.out.println(i + 1 + " - " + Main.options.get(i));
    System.out.print("Choose an option: ");
    Integer option = scanner.nextInt();
    return option;
  } 

  public static void start(Scanner scanner) throws Exception {
    while(true) {
      try {
        connection = ConnectionFactory.getConnection();
        Main.clearScreen();
        Integer option = Main.showMainMenu(scanner);

        if(option == 1) {
          Main.clearScreen();
          TextIO textIO = TextIoFactory.getTextIO();
          System.out.println("----- Create employee ----- ");

          String name = textIO.newStringInputReader().read("name");
          String cpf = textIO.newStringInputReader().withPattern("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d").read("cpf");
          String phone =  textIO.newStringInputReader().withPattern("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d").read("phone");
          String email = textIO.newStringInputReader().withPattern("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+").read("email");
          String registration = textIO.newStringInputReader().withPattern("\\d+").read("registration");
          CreateEmployeeUseCaseFactory.factory(connection).exec(new CreateEmployeeInputDTO(cpf, registration, name, email, phone));
        }

        else if(option == 2) {
          Main.clearScreen();
          TextIO textIO = TextIoFactory.getTextIO();
          System.out.println("----- List all employees -----");

          Integer page = textIO.newIntInputReader().read("page");
          Integer limit = textIO.newIntInputReader().read("limit");

          List<Employee> employees = ListEmployeesUseCaseFactory.factory(connection).exec(new ListEmployeeInputDTO(page, limit));
          for(Employee e: employees) {
            System.out.println(e);
          }
        }

        else if(option == 3) {
          Main.clearScreen();
          TextIO textIO = TextIoFactory.getTextIO();
          System.out.println("----- Delete employee -----");

          String employeeId = textIO.newStringInputReader().read("id");
          DeleteByIdEmployeeUseCaseFactory.factory(connection).exec(employeeId);
        }

        else if(option == 4) {
          Main.clearScreen();
          TextIO textIO = TextIoFactory.getTextIO();
          System.out.println("----- Update employee -----");

          String id = textIO.newStringInputReader().read("employee id to be updated");
          String name = textIO.newStringInputReader().read("name");
          String cpf = textIO.newStringInputReader().withPattern("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d").read("cpf");
          String phone =  textIO.newStringInputReader().withPattern("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d").read("phone");
          String email = textIO.newStringInputReader().withPattern("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+").read("email");
          String registration = textIO.newStringInputReader().withPattern("\\d\\d\\d\\d\\d\\d").read("registration");
          UpdateByIdEmployeeUseCaseFactory.factory(connection).exec(new UpdateEmployeeInputDTO(id, cpf, registration, name, email, phone));
        }

        else {
          throw BadError.badError();
        }

      } catch(EmployeeErrors err) {
        System.out.println("\n--- Error ----");
        System.out.println("Code: " + err.getBody().getCode());
        System.out.println("ShortMessage: " + err.getBody().getShortMessage());
        System.out.println("Message: " + err.getBody().getMessage() + "\n");
      } catch(Error err) {
        System.out.println("\n--- Error ----");
        System.out.println("Code: " + err.getBody().getCode());
        System.out.println("ShortMessage: " + err.getBody().getShortMessage());
        System.out.println("Message: " + err.getBody().getMessage() + "\n");
      } 
      finally {
        System.out.print("Do you want keep? (1/0): ");
        Integer optionKeep = scanner.nextInt();

        if(optionKeep == 0)
          break;
      }
    }
  }
}
