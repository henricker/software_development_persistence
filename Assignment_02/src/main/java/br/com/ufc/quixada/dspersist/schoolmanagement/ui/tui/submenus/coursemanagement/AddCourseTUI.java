package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.coursemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.course.CreateCourseDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.CourseService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class AddCourseTUI extends GenericTUI {
  
  @Autowired
  private CourseService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("---- Informações da disciplina ------");
    
    System.out.print("Nome: ");
    String name = scanner.next();
 
    System.out.print("Código: ");
    String code = scanner.next();


    this.service.create(new CreateCourseDTO(code, name));
    System.out.println("Disciplina adicionada com sucesso!");
  }
}
