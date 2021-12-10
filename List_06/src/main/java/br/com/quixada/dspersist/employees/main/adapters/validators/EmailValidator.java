package br.com.quixada.dspersist.employees.main.adapters.validators;

import org.springframework.stereotype.Service;
import br.com.quixada.dspersist.employees.domain.business.service.IValidator;

@Service
public class EmailValidator implements IValidator {

  @Override
  public Boolean validate(Object arg) {
    if(!(arg instanceof String))
      return false;
    
    String value = (String) arg;

    if(!value.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+"))
      return false;

    return true;
  }

}
