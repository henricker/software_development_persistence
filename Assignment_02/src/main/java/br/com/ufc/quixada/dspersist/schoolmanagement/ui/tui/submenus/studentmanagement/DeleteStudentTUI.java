package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class DeleteStudentTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("--- Informações de busca -----");
    System.out.print("Id do estudante: ");
    Long id = scanner.nextLong();  
 
    this.service.delete(id);

    System.out.println("Estudante deletado com sucesso!");
  }
  
}
