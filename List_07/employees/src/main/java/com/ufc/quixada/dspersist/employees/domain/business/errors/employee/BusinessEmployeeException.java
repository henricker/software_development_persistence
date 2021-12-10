package com.ufc.quixada.dspersist.employees.domain.business.errors.employee;

import com.ufc.quixada.dspersist.employees.shared.error.BusinessException;

public class BusinessEmployeeException extends BusinessException {

  public BusinessEmployeeException(String message, String code, String shortMessage) {
    super(message, code, shortMessage);
  }

  public static BusinessException cpfAlreayExistsError() {
    return new BusinessEmployeeException(
      "CPF já cadastrado!", 
      "UE-001", 
      "CPFAlreadyExistsError"
    );
  }

  public static BusinessException registrationAlreadyExistsError() {
    return new BusinessEmployeeException(
      "Matrícula já cadastrada!", 
      "UE-002", 
      "RegistrationAlreadyExistsError"
    );
  }

  public static BusinessException employeeNotFoundError() {
   return new BusinessEmployeeException(
     "Funcionário não encontrado", 
     "UE-003", 
     "EmployeeNotFoundError"
    );
  }
}