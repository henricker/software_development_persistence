package br.com.ufc.quixada.dspersist.schoolmanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.CourseException;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.StudentException;
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

    if(studentOptional.isEmpty())
      throw StudentException.studentNotFoundError();

    Optional<Course> courseOptional = this.courseRepository.findById(courseId);

    if(courseOptional.isEmpty())
      throw CourseException.courseNotFoundError();

    Optional<StudentCourse> hasEnroll = this.studentCourseRepository.findByStudentAndCourse(studentId, courseId);

    if(hasEnroll.isPresent()) 
      throw CourseException.studentAlreadyEnrolledError();
    
    this.studentCourseRepository.save(new StudentCourse(studentId, courseId));
  }

  public void unenroll(Long studentId, Long courseId) {
    Optional<Student> studentOptional = this.studentRepository.findById(studentId);

    if(!studentOptional.isPresent())
      throw StudentException.studentNotFoundError();

    Optional<Course> courseOptional = this.courseRepository.findById(courseId);

    if(!courseOptional.isPresent())
      throw CourseException.courseNotFoundError();

    Optional<StudentCourse> sc = this.studentCourseRepository.findByStudentAndCourse(studentId, courseId);

    if(!sc.isPresent())
      throw CourseException.studentNotEnrolledError();

    this.studentCourseRepository.deleteById(sc.get().getId());
  }
}
