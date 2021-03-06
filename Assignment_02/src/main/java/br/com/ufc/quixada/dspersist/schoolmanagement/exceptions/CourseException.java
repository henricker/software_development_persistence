package br.com.ufc.quixada.dspersist.schoolmanagement.exceptions;

public class CourseException extends BusinessException {

  public CourseException(Integer code, String shortMessage, String message) {
    super(code, shortMessage, message);
  }

  public static BusinessException courseNotFoundError() {
    return new CourseException(
      404, 
      "CourseNotFoundError", 
      "Disciplina não encontrada"
    ); 
  }

  public static BusinessException codeAlreadyExistsError() {
    return new CourseException(
      400, 
      "CodeAlreadyExistsError", 
      "Código do curso já está em uso"
    );
  }

  public static BusinessException studentAlreadyEnrolledError() {
    return new CourseException(
      400, 
      "studentAlreadyEnrolledError", 
      "Estudante já matriculado nessa disciplina"
    );
  }

  public static BusinessException studentNotEnrolledError() {
    return new CourseException(
      404, 
      "studentNotEnrolledError", 
      "Estudante não está matriculado nessa disciplina"
    );
  }
}
