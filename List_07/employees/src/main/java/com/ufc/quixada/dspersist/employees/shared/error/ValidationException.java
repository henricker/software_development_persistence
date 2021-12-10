package com.ufc.quixada.dspersist.employees.shared.error;

public class ValidationException extends RuntimeException {
  private final String field;
  private final String code;

  public ValidationException(String message, String code, String field) {
    super(message);
    this.field = field;
    this.code = code;
  }

  public String getBodyError() {
    StringBuilder sb = new StringBuilder();
    sb.append("---- Validation Error -----\n");
    sb.append("code: " + this.code + "\n");
    sb.append("field: " + this.field + "\n");
    sb.append("message: " + this.getMessage() + "\n");
    return sb.toString();
  }
  
}