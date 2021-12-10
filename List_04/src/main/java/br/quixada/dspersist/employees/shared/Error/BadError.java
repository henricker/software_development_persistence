package br.quixada.dspersist.employees.shared.Error;

public class BadError extends Error {

  public BadError(Integer statusCode, ErrorBody body) {
    super(statusCode, body);
  }

  public static BadError badError() {
    return new BadError(400, new ErrorBody("BE-01", "InvalidParamError", "invalid option error, please try again"));
  }
  
}
