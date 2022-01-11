package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.StudentCourse;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.StudentRepository;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.CourseService;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class FindStudentsByCodeCourseTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("---- Informações de busca -----");
    System.out.print("Código da disciplina: ");
    String code = scanner.next();
  
    Set<Student> students = this.service.findStudentsByCodeOfCourse(code);
    if(students.isEmpty()) {
      System.out.println("[]");
    }
    else {
      students.forEach(System.out::println);
    }

    System.out.println();
  }
  
}
