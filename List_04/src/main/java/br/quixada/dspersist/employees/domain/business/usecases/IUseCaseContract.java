package br.quixada.dspersist.employees.domain.business.usecases;

public interface IUseCaseContract<Input, Output> {
  public Output exec(Input obj);
}
