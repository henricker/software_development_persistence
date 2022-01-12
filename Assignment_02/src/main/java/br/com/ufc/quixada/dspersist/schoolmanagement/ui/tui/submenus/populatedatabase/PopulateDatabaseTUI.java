package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.populatedatabase;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.CreateStudentDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;

@Service
public class PopulateDatabaseTUI extends GenericTUI {

  @Autowired
  private StudentService service;

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }
  
  @Override
  public void run() {
    service.create(
      new CreateStudentDTO("12332144455", "090807", "leandro@fernandes.com", "Leandro Fernandes", LocalDate.of(2000, 9, 15))
    );

    service.create(
      new CreateStudentDTO("76777766655", "555555", "leandro@karnal.com", "Leandro Karnal", LocalDate.of(1974, 10, 5))
    );

    service.create(
      new CreateStudentDTO("77788899966", "444444", "henrique@pereira.com", "Henrique Pereira", LocalDate.of(1960, 10, 1))
    );

    service.create(
      new CreateStudentDTO("44499988877", "333333", "juliano@silva.com", "Juliano Silva", LocalDate.of(1980, 4, 8))
    );

    service.create(
      new CreateStudentDTO("76689712368", "222222", "fernando@email.com", "Fernando Marques", LocalDate.of(2000, 9, 15))
    );

    service.create(
      new CreateStudentDTO("09871234673", "777777", "juliana@email.com", "Juliana Garcia", LocalDate.of(2000, 9, 15))
    );

    service.create(
      new CreateStudentDTO("66886611123", "999999", "ylana@alves.com", "Ylana Alves", LocalDate.of(2000, 1, 2))
    );

    System.out.println("Entidades adicionadas com sucesso!");
    System.out.println();
  }
}
