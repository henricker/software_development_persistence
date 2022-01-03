package br.com.ufc.quixada.dspersist.schoolmanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Course;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.StudentCourse;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.CourseRepository;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.StudentCourseRepository;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.StudentRepository;

@Service
public class StudentCourseService {

  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private CourseRepository courseRepository;
  @Autowired
  private StudentCourseRepository studentCourseRepository;

  public void enroll(Long studentId, Long courseId) {
  
    Optional<Student> studentOptional = this.studentRepository.findById(studentId);

    if(!studentOptional.isPresent())
      throw new RuntimeException("Estudante não encontrado");

    Optional<Course> courseOptional = this.courseRepository.findById(courseId);

    if(!courseOptional.isPresent())
      throw new RuntimeException("Disciplina não encontrada");

    Student student = studentOptional.get();
    Course course = courseOptional.get();

    StudentCourse sc = new StudentCourse(studentId, courseId);

    if(student.getStudentCourses().contains(sc))
      throw new RuntimeException("Estudante já está matriculado nessa discplina");
    
    this.studentCourseRepository.save(sc);
  }

  public void unenroll(Long studentId, Long courseId) {
    Optional<Student> studentOptional = this.studentRepository.findById(studentId);

    if(!studentOptional.isPresent())
      throw new RuntimeException("Estudante não encontrado");

    Optional<Course> courseOptional = this.courseRepository.findById(courseId);

    if(!courseOptional.isPresent())
      throw new RuntimeException("Disciplina não encontrada");

    Optional<StudentCourse> sc = this.studentCourseRepository.findByStudentAndCourse(studentId, courseId);

    if(!sc.isPresent())
      throw new RuntimeException("Estudante não matriculado");

    this.studentCourseRepository.deleteById(sc.get().getId());
  }
}
