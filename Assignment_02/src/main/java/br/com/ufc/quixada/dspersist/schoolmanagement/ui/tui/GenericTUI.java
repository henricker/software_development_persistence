package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui;

import java.util.Scanner;

public abstract class GenericTUI {
  protected Scanner scanner = null;
  
  protected abstract GenericTUI getOption();
  
  public void run() {
    GenericTUI option = getOption();
    option.setScanner(scanner).run();
  }
  
  public GenericTUI setScanner(Scanner scanner) {
    this.scanner = scanner;
    return this;
  }
}
