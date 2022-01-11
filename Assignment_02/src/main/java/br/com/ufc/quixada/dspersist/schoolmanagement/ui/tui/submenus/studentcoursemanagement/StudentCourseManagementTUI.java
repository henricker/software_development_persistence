package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentcoursemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.InvalidOptionTui;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util.TuiUtil;

@Service
public class StudentCourseManagementTUI extends GenericTUI {

  @Autowired
  private EnrollTUI enrollTUI;

  @Autowired
  private UnenrollTUI unenrollTUI;

  @Autowired
  private InvalidOptionTui invalidOptionTui;

  @Override
  protected GenericTUI getOption() {
    StringBuilder menu = new StringBuilder();
    TuiUtil.clearScreen();
    menu.append("------ Módulo de Alunos/Disciplinas ------ \n");
    menu.append("1 - Matricular\n");
    menu.append("2 - Desmatricular\n");
    System.out.println(menu.toString());
    System.out.print("Escolha sua opção: ");
    Integer chooseOption = scanner.nextInt();
    
    switch(chooseOption) {
      case 1: return enrollTUI;
      case 2: return unenrollTUI;
    }

    return invalidOptionTui;
  }
  
}
