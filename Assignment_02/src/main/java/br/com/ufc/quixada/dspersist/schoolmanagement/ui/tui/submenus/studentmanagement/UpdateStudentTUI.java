package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentmanagement;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.UpdateStudentDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class UpdateStudentTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("------ Informações de busca -------");
    System.out.print("ID do estudante: ");
    Long id = scanner.nextLong();
    System.out.println("------ Informações pessoais ------ ");
    System.out.print("Nome: ");
    String name = scanner.next();
    System.out.print("Sobrenome: ");
    String lastName = scanner.next();
    System.out.print("Email: ");
    String email = scanner.next();
    System.out.print("CPF: ");
    String cpf = scanner.next();
    System.out.println("----- Informações da faculdade -----");
    System.out.print("Matrícula: ");
    String registration = scanner.next();
    System.out.println("----- Data de Nascimento ------");
    System.out.print("Dia: ");
    Integer dayBorn = scanner.nextInt();
    System.out.print("Mês: ");
    Integer monthBorn = scanner.nextInt();
    System.out.print("Ano: ");
    Integer yearBorn = scanner.nextInt();

   this.service.update(new UpdateStudentDTO(id, cpf, name + " " + lastName, registration, email, LocalDate.of(yearBorn, monthBorn, dayBorn)));

    System.out.println("Estudante atualizado com sucesso!");
  }
  
}
