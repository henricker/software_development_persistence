package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.InvalidOptionTui;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util.TuiUtil;

@Service
public class ReportTUI extends GenericTUI {

  @Autowired
  private FindStudentByNameTUI findStudentByNameTUI;

  @Autowired
  private FindStudentsByCodeCourseTUI findStudentsByCodeCourseTUI;

  @Autowired
  private FindNameAndCoutingCoursesTUI findNameAndCoutingCoursesTUI;

  @Autowired
  private FindNameAndEmailByRegistrationTUI findNameAndEmailByRegistrationTUI;

  @Autowired
  private FindStudentsByBornDateTUI findStudentsByBornDateTUI;

  @Autowired
  private InvalidOptionTui invalidOptionTui;

  @Override
  protected GenericTUI getOption() {
    StringBuilder menu = new StringBuilder();
    TuiUtil.clearScreen();
    menu.append("------ Relatórios ------ \n");
    menu.append("1 - Buscar nome dos estudantes com suas disciplinas pelo nome\n");
    menu.append("2 - Buscar estudantes pelo código da disciplina\n");
    menu.append("3 - Buscar nomes dos alunos com a quantidade de disciplinas cursando\n");
    menu.append("4 - Buscar nome e email de um aluno pela sua matrícula\n");
    menu.append("5 - Buscar estudantes que nasceram após determinada data\n");
    System.out.println(menu.toString());
    System.out.print("Escolha sua opção: ");
    Integer chooseOption = scanner.nextInt();
    
    switch(chooseOption) {
      case 1: return findStudentByNameTUI;
      case 2: return findStudentsByCodeCourseTUI;
      case 3: return findNameAndCoutingCoursesTUI;
      case 4: return findNameAndEmailByRegistrationTUI;
      case 5: return findStudentsByBornDateTUI;
    }

    return invalidOptionTui;
  }
  
}
