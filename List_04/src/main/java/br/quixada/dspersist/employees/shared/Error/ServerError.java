package br.quixada.dspersist.employees.shared.Error;

public class ServerError extends Error {

  public ServerError(Integer statusCode, ErrorBody body) {
    super(statusCode, body);
  }

  public static ServerError serverError() {
    return new ServerError(500, new ErrorBody(
      "SERVER-01",
      "DatabaseError",
      "An error occurred in our database, please try again later"
    ));
  }

}
