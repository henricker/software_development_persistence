package com.ufc.quixada.dspersist.employees.main.ui.tui.util;


public class TUIUtil {

  private TUIUtil() {
    throw new IllegalStateException("Utility class");
  }
  
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}