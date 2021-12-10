package com.ufc.quixada.dspersist.employees.main.adapters.validators;

import com.ufc.quixada.dspersist.employees.domain.business.validator.IValidator;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements IValidator {

  @Override
  public Boolean validate(Object arg) {
    if(!(arg instanceof String))
      return false;
    
    String value = (String) arg;

    return value.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+");
  }

}