package br.com.ufc.quixada.dspersist.schoolmanagement.exceptions;


public class StudentException extends BusinessException {
  public StudentException(Integer code, String shortMessage, String message) {
    super(code, shortMessage, message);
  }

  public static BusinessException studentNotFoundError() {
    return new StudentException(
      404, 
      "StudentNotFoundException", 
      "Estudante não encontrado"
    );
  }

  public static BusinessException cpfAlreadyInUseError() {
    return new StudentException(
      400, 
      "CPFAlreadyInUseError", 
      "CPF já está cadastrado"
    );
  }

  public static BusinessException registrationAlreadyInUseError() {
    return new StudentException(
      400, 
      "registrationAlreadyInUseError", 
      "Matrícula já está cadastrada"
    );
  }

  public static BusinessException emailAlreadyInUseError() {
    return new StudentException(
      400, 
      "emailAlreadyInUseError", 
      "Email já cadastrado"
    );
  }  
}
