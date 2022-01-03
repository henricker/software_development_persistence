package br.com.ufc.quixada.dspersist.schoolmanagement.dto.course;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateCourseDTO {
  private String code;
  private String name;

  public Course export() {
    return new Course(code, name);
  }
}
