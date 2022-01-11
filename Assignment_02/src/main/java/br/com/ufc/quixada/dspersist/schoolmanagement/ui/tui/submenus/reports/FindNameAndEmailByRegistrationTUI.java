package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IStudentIdNameAndEmail;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class FindNameAndEmailByRegistrationTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }
  
  @Override
  public void run() {
    System.out.println(" ---- Informações de busca ---- ");
    System.out.print("Matrícula do aluno: ");
    String registration  = scanner.next();

    IStudentIdNameAndEmail student = this.service.findByRegistration(registration);

    System.out.println("---- Estudante encontrado! -----");
    System.out.println("nome: " + student.getName() + " email: " + student.getEmail());
    System.out.println();
  }

}
