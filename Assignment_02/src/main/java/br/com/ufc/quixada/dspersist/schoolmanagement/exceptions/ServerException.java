package br.com.ufc.quixada.dspersist.schoolmanagement.exceptions;

public class ServerException extends RuntimeException {
  private final Integer code = 500;
  private final String shortMessage = "serverError";

  public ServerException() {
    super("Erro interno do servidor!");
  }

  public static RuntimeException serverError() {
    return new ServerException();
  }

  public String showMessage() {
    StringBuilder sb = new StringBuilder();
    sb.append("---- " + this.shortMessage + "----\n");
    sb.append("code: " + this.code + "\n");
    sb.append("message: " + this.getMessage());
    return sb.toString();
  }
}
