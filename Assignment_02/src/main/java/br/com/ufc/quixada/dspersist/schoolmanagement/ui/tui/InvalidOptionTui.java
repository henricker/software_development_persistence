package br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui;

import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;

@Service
public class InvalidOptionTui extends GenericTUI {

  @Override
  protected GenericTUI getOption() {
    throw new ServerException();
  }

  @Override
  public void run() {
    System.out.println("Opção inválida!, tente novamente");
  }
}
