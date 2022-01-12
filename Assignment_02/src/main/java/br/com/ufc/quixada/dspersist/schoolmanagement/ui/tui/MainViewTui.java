package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.coursemanagement.CourseManagementTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.populatedatabase.PopulateDatabaseTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.reports.ReportTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentcoursemanagement.StudentCourseManagementTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.submenus.studentmanagement.StudentManagementTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util.TuiUtil;

@Service
@Primary
public class MainViewTui extends GenericTUI {

  @Autowired
  private StudentManagementTUI studentManagementTUI;
  
  @Autowired
  private CourseManagementTUI courseManagementTUI;

  @Autowired
  private StudentCourseManagementTUI studentCourseManagementTUI;

  @Autowired
  private PopulateDatabaseTUI populateDatabaseTUI;

  @Autowired
  private ReportTUI reportTUI;

  @Autowired
  private InvalidOptionTui invalidOptionTui;

  @Override
  protected GenericTUI getOption() {
    StringBuilder menu = new StringBuilder();
    TuiUtil.clearScreen();
    menu.append("------ Si3 ------ \n");
    menu.append("1 - Gerenciar Alunos\n");
    menu.append("2 - Gerenciar Disciplinas\n");
    menu.append("3 - Alunos/Discilinas\n");
    menu.append("4 - Relatórios\n");
    menu.append("5 - Preencher banco");
    TuiUtil.clearScreen();
    System.out.println(menu.toString());
    System.out.print("Escolha sua opção: ");
    Integer chooseOption = scanner.nextInt();

    switch(chooseOption) {
      case 1: return studentManagementTUI;
      case 2: return courseManagementTUI;
      case 3: return studentCourseManagementTUI;
      case 4: return reportTUI;
      case 5: return populateDatabaseTUI;
      default: break;
    }

    return invalidOptionTui;
  }
}
