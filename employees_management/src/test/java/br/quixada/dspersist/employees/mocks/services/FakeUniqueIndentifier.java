package br.quixada.dspersist.employees.mocks.services;

import br.quixada.dspersist.employees.business.services.uniqueIndentifier.IUniqueIndentifier;

public class FakeUniqueIndentifier implements IUniqueIndentifier {

  @Override
  public String create() {
    return "valid_uuid";
  }
}
