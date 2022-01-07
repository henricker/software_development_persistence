package br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions;

import java.util.List;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.StudentCourse;

public interface IFindNameOfStudentWithCourses {
  String getName();
  List<StudentCourse> getStudentCourses();
}
