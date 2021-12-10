package com.ufc.quixada.dspersist.employees.shared.error;

public class ServerException extends RuntimeException {
  private final String code;

  public ServerException(String message) {
    super(message);
    this.code = "SE-001";
  }

  public String getBodyError() {
    StringBuilder sb = new StringBuilder();
    sb.append("---- Server Error -----\n");
    sb.append("code: " + this.code + "\n");
    sb.append("message: " + this.getMessage() + "\n");
    return sb.toString();
  }
  
}