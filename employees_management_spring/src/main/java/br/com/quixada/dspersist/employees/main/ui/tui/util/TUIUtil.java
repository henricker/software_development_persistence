package br.com.quixada.dspersist.employees.main.ui.tui.util;

public class TUIUtil {
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
