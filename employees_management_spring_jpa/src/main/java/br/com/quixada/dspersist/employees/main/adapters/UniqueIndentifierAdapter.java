package br.com.quixada.dspersist.employees.main.adapters;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.quixada.dspersist.employees.domain.business.service.IUniqueIndentifier;

@Service
public class UniqueIndentifierAdapter implements IUniqueIndentifier {

  @Override
  public String create() {
    return UUID.randomUUID().toString();
  }
}
