package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.InvalidOptionTui;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util.TuiUtil;

@Service
public class StudentManagementTUI extends GenericTUI {

  @Autowired
  private AddStudentTUI addStudentTUI;

  @Autowired
  private UpdateStudentTUI updateStudentTUI;

  @Autowired
  private DeleteStudentTUI deleteStudentTUI;

  @Autowired
  private InvalidOptionTui invalidOptionTui;

  @Override
  protected GenericTUI getOption() {
    StringBuilder menu = new StringBuilder();
    TuiUtil.clearScreen();
    menu.append("------ Módulo de estudantes ------ \n");
    menu.append("1 - Adicionar\n");
    menu.append("2 - Atualizar\n");
    menu.append("3 - Deletar\n");
    System.out.println(menu.toString());
    System.out.print("Escolha sua opção: ");
    Integer chooseOption = scanner.nextInt();
    
    switch(chooseOption) {
      case 1: return addStudentTUI;
      case 2: return updateStudentTUI;
      case 3: return deleteStudentTUI;
    }

    return invalidOptionTui;
  }
}
