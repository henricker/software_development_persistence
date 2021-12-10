package com.ufc.quixada.dspersist.employees.main.adapters.validators;

import com.ufc.quixada.dspersist.employees.domain.business.validator.IValidator;

import org.springframework.stereotype.Service;

@Service
public class CPFValidator implements IValidator {

  @Override
  public Boolean validate(Object arg) {
   
    if(!(arg instanceof String))
      return false;

    String value = (String) arg;

    return value.matches("^\\d{11}$");
  }
  
}
