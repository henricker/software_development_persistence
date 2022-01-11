package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class FindStudentsByBornDateTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }
  
  @Override
  public void run() {
    System.out.println("---- Buscar por data de nascimento -----");
    System.out.print("Dia: ");
    Integer dayBorn = scanner.nextInt();
    System.out.println("Mês: ");
    Integer monthBorn = scanner.nextInt();
    System.out.println("Ano: ");
    Integer yearBorn = scanner.nextInt();

    Set<Student> students = this.service.findByBornDate(LocalDate.of(yearBorn, monthBorn, dayBorn));

    students.forEach(System.out::println);
    System.out.println();
  }
}
