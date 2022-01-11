package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.coursemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.course.UpdateCourseDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.CourseService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class UpdateCourseTUI extends GenericTUI {

  @Autowired
  private CourseService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("----- Informações de busca ----- ");
    System.out.print("ID do curso: ");
    Long id = scanner.nextLong();
    System.out.println("---- Informações da disciplina ------");
    System.out.print("Nome: ");
    String name = scanner.next();
 
    System.out.print("Código: ");
    String code = scanner.next();


    this.service.update(new UpdateCourseDTO(id, name, code));
    System.out.println("Disciplina atualizada com sucesso!");
    
  }
  
}
