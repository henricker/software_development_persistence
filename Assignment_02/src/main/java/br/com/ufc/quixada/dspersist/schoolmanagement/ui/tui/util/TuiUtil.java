package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util;


public class TuiUtil {

  private TuiUtil() {
    throw new IllegalStateException("Utility class");
  }
  
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}