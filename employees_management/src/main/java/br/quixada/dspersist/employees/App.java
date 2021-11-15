package br.quixada.dspersist.employees;

import java.util.Scanner;

import br.quixada.dspersist.employees.main.ui.tui.Main;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    Main.start(scanner);
  }
}
