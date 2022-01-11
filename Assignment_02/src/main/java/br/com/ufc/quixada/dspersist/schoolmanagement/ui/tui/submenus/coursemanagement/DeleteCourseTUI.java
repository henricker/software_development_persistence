package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.coursemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.CourseService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class DeleteCourseTUI extends GenericTUI {

  @Autowired
  private CourseService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("--- Informações de busca -----");
    System.out.println("Id da disciplina: ");
    Long id = scanner.nextLong();  
 
    this.service.delete(id);

    System.out.println("Disciplina deletada com sucesso!");
  }
  
}
