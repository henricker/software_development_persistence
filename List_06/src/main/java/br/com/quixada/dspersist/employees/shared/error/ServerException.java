package br.com.quixada.dspersist.employees.shared.error;

public class ServerException extends RuntimeException {
  private String code;

  public ServerException(String message) {
    super(message);
    this.code = "SE-001";
  }

  public String getBodyError() {
    StringBuffer sb = new StringBuffer();
    sb.append("---- Server Error -----\n");
    sb.append("code: " + this.code + "\n");
    sb.append("message: " + this.getMessage() + "\n");
    return sb.toString();
  }
  
}
