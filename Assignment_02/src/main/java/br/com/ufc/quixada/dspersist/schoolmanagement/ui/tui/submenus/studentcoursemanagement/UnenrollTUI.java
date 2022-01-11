package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentcoursemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentCourseService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class UnenrollTUI extends GenericTUI {

  @Autowired
  private StudentCourseService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }
  

  @Override
  public void run() {
    System.out.println("---- Informações para matrícula -----");
    System.out.print("ID do estudante: ");
    Long studentId = scanner.nextLong();
    System.out.print("ID da disciplina: ");
    Long courseId = scanner.nextLong();

    this.service.unenroll(studentId, courseId);

    System.out.println("Estudante desmatriculado com sucesso!");
  }
}
