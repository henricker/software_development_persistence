package br.com.ufc.quixada.dspersist.schoolmanagement.dto.course;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateCourseDTO {
  private Long id;
  private String name;
  private String code;

  public Course export() {
    return new Course(id, code, name);
  }
}
