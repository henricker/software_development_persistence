package br.com.ufc.quixada.dspersist.schoolmanagement.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.CreateStudentDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.UpdateStudentDTO;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IFindNameOfStudentWithCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IStudentIdNameAndEmail;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IStudentNameAndCountingCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.StudentException;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.StudentRepository;

@Service
public class StudentService {
  
  @Autowired
  private StudentRepository repository;

  public void create(CreateStudentDTO dto) {

    Boolean emailExists = this.repository.findByEmail(dto.getEmail()).isPresent();

    if(Boolean.TRUE.equals(emailExists))
      throw StudentException.cpfAlreadyInUseError();

    Boolean registrationExists = this.repository.findByRegistration(dto.getRegistration()).isPresent();

    if(Boolean.TRUE.equals(registrationExists))
      throw StudentException.registrationAlreadyInUseError();

    Boolean cpfExists = this.repository.findByCpf(dto.getCpf()).isPresent();

    if(Boolean.TRUE.equals(cpfExists))
      throw StudentException.cpfAlreadyInUseError();

    this.repository.save(dto.export());
  }

  public List<Student> list() {
    return this.repository.findAll();
  }

  public void delete(Long studentId) {

    if(!this.repository.findById(studentId).isPresent())
      throw StudentException.studentNotFoundError();

    this.repository.deleteById(studentId);
  }

  public void update(UpdateStudentDTO dto) {
    Optional<Student> studentExists = this.repository.findById(dto.getId());

    if(!studentExists.isPresent())
      throw StudentException.studentNotFoundError();
      
    Optional<Student> emailExists = this.repository.findByEmail(dto.getEmail());

    if(Boolean.TRUE.equals(emailExists.isPresent()) && !emailExists.get().getId().equals(dto.getId()))
      throw StudentException.emailAlreadyInUseError();

    Optional<IStudentIdNameAndEmail> registrationExists = this.repository.findByRegistration(dto.getRegistration());

    if(Boolean.TRUE.equals(registrationExists.isPresent()) && !registrationExists.get().getId().equals(dto.getId()))
      throw StudentException.registrationAlreadyInUseError();

    Optional<Student> cpfExists = this.repository.findByCpf(dto.getCpf());

    if(Boolean.TRUE.equals(cpfExists.isPresent()) && !cpfExists.get().getId().equals(dto.getId()))
      throw StudentException.cpfAlreadyInUseError();

    this.repository.save(dto.export());
  }

  public IStudentIdNameAndEmail findByRegistration(String registration) {
    Optional<IStudentIdNameAndEmail> studentOptional = this.repository.findByRegistration(registration);
    
    if(!studentOptional.isPresent())
      throw StudentException.studentNotFoundError();

    return studentOptional.get();
  }

  public Set<Student> findByBornDate(LocalDate date) {
    return this.repository.findByDate(date);
  }

  public Set<IStudentNameAndCountingCourses> findNameAndCountingByStudent() {
    return this.repository.findStudentsNameAndQuantityOfCourses();
  }

  public Set<IFindNameOfStudentWithCourses> findNameAndCoursesByStudentNameStartsWith(String name) {
    return this.repository.findNameAndCoursesOfStudent(name);
  }
}
