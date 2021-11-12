package employees.business.usecases;

public interface IUseCaseContract<Input, Output> {
  public Output exec(Input obj);
}
