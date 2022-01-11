package br.com.ufc.quixada.dspersist.schoolmanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.course.CreateCourseDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.course.UpdateCourseDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.CourseException;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Course;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.CourseRepository;

@Service
public class CourseService {
  @Autowired
  private CourseRepository repository;

  public void create(CreateCourseDTO dto) {

    Boolean codeExists = this.repository.findByCode(dto.getCode()).isPresent();

    if(Boolean.TRUE.equals(codeExists))
      throw CourseException.codeAlreadyExistsError();

    this.repository.save(dto.export());
  }

  public List<Course> list() {
    return this.repository.findAll();
  }

  public void delete(Long courseId) {

    if(!this.repository.findById(courseId).isPresent())
      throw CourseException.courseNotFoundError();

    this.repository.deleteById(courseId);
  }

  public void update(UpdateCourseDTO dto) {
    Optional<Course> courseExists = this.repository.findById(dto.getId());

    if(!courseExists.isPresent())
      throw CourseException.courseNotFoundError();
      
    Optional<Course> codeExists = this.repository.findByCode(dto.getCode());

    if(Boolean.TRUE.equals(codeExists.isPresent()) && !codeExists.get().getId().equals(dto.getId()))
      throw CourseException.codeAlreadyExistsError();

    this.repository.save(dto.export());
  }
}
