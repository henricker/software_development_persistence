package br.quixada.dspersist.employees.main.adapters;

import java.util.UUID;

import br.quixada.dspersist.employees.domain.business.services.uniqueIndentifier.IUniqueIndentifier;

public class UniqueIndentifierAdapter implements IUniqueIndentifier{
  @Override
  public String create() {
    return UUID.randomUUID().toString();
  }
}
