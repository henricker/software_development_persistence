package br.com.ufc.quixada.dspersist.schoolmanagement.dto.student;

import java.time.LocalDate;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class CreateStudentDTO {
  private String cpf;
  private String registration;
  private String email;
  private String name;
  private LocalDate bornDate;

  public Student export() {
    return new Student(cpf, registration, email, name, bornDate);
  }
}
