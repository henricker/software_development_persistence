package br.com.ufc.quixada.dspersist.schoolmanagement.dto.student;

import java.time.LocalDate;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateStudentDTO {
  private Long id;
  private String cpf;
  private String name;
  private String registration;
  private String email;
  private LocalDate bornDate;

  public Student export() {
    return new Student(id, cpf, registration, email, name, bornDate);
  }
}
