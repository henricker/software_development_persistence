package com.ufc.quixada.dspersist.employees.shared.error;


public class BusinessException extends RuntimeException {
  private final String code;
  private final String shortMessage;

  public BusinessException(String message, String code, String shortMessage) {
    super(message);
    this.code = code;
    this.shortMessage = shortMessage;
  }

  public String getBodyError() {
    StringBuilder sb = new StringBuilder();
    sb.append("---- Business Error -----\n");
    sb.append("code: " + this.code + "\n");
    sb.append("shortMessage: " + this.shortMessage + "\n");
    sb.append("message: " + this.getMessage() + "\n");
    return sb.toString();
  }
}