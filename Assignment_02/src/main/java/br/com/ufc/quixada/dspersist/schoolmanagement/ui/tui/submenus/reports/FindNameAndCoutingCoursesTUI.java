package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IStudentNameAndCountingCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class FindNameAndCoutingCoursesTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }
  
  @Override
  public void run() {
    Set<IStudentNameAndCountingCourses> data = this.service.findNameAndCountingCourseByStudent();

    System.out.println(" ---- Relatório de quantidade de disciplinas por aluno ---- ");
    data.forEach((IStudentNameAndCountingCourses s) -> {
      System.out.println("Nome: " + s.getName() + " | Quantidade de disciplinas: " + s.getCountOfCourses());
    });
    System.out.println();
  }
}
