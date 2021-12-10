package com.ufc.quixada.dspersist.employees.main.ui.tui.errors;

import com.ufc.quixada.dspersist.employees.shared.error.ValidationException;

public class FieldsValidationException extends ValidationException {

  public FieldsValidationException(String message, String code, String field) {
    super(message, code, field);
  }

  public static ValidationException cpfvalidationError() {
    return new FieldsValidationException("CPF inválido", "VE-001", "cpf");
  }

  public static ValidationException registrationValidationError() {
    return new FieldsValidationException("Matrícula inválida", "VE-002", "matrícula");
  }

  public static ValidationException emailValidationError() {
    return new FieldsValidationException("Email inválido", "VE-003", "email");
  }
}
