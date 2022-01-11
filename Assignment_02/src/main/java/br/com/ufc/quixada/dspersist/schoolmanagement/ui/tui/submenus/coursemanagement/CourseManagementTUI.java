package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.coursemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.InvalidOptionTui;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util.TuiUtil;

@Service
public class CourseManagementTUI extends GenericTUI {

  @Autowired
  private AddCourseTUI addCourseTUI;

  @Autowired
  private UpdateCourseTUI updateCourseTUI;

  @Autowired
  private DeleteCourseTUI deleteCourseTUI;

  @Autowired
  private InvalidOptionTui invalidOptionTui;

  @Override
  protected GenericTUI getOption() {
    StringBuilder menu = new StringBuilder();
    TuiUtil.clearScreen();
    menu.append("------ Módulo de disciplinas ------ \n");
    menu.append("1 - Adicionar\n");
    menu.append("2 - Atualizar\n");
    menu.append("3 - Deletar\n");
    System.out.println(menu.toString());
    System.out.print("Escolha sua opção: ");
    Integer chooseOption = scanner.nextInt();
    
    switch(chooseOption) {
      case 1: return addCourseTUI;
      case 2: return updateCourseTUI;
      case 3: return deleteCourseTUI;
    }

    return invalidOptionTui;
  }
}
