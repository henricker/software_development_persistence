package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IFindNameOfStudentWithCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.StudentCourse;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class FindStudentByNameTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }
  
  @Override
  public void run() {
    System.out.println("----- Informações de busca -----");
    System.out.print("String de busca: ");
    String stringSearch = scanner.next();

    Set<IFindNameOfStudentWithCourses> data = this.service.findNameAndCoursesByStudentNameStartsWith(stringSearch);
    
    System.out.println("--- Relatório de disciplinas por estudante ----");
    data.forEach((IFindNameOfStudentWithCourses result) -> {
      System.out.println("---- Estudante -----");
      System.out.println("nome: " + result.getName());
      System.out.println("---- disciplinas cursando ----");
      result.getStudentCourses().forEach((StudentCourse sc) -> {
        System.out.println("nome: " + sc.getCourse().getName() + " | código: " + sc.getCourse().getName());
      });
    });
    System.out.println();
  }

}
