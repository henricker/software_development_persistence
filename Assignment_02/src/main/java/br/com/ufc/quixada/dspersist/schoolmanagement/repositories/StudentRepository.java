package br.com.ufc.quixada.dspersist.schoolmanagement.repositories;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IFindNameOfStudentWithCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IStudentIdNameAndEmail;
import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IStudentNameAndCountingCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  public Optional<Student> findByEmail(String email);
  
  @Query("SELECT s.name as name, s.email as email, s.id as id FROM Student s WHERE s.registration = :registration")
  public Optional<IStudentIdNameAndEmail> findByRegistration(@Param("registration") String registration);
  
  public Optional<Student> findByCpf(String cpf);

  @Query("SELECT s FROM Student s WHERE s.bornDate >= :bornDate")
  public Set<Student> findByDate(@Param("bornDate") LocalDate bornDate);

  @Query("SELECT s.name as name, COUNT(sc.id) as countOfCourses FROM Student s JOIN s.studentCourses sc GROUP BY s.name")
  public Set<IStudentNameAndCountingCourses> findStudentsNameAndQuantityOfCourses();

  @Query("SELECT s FROM Student s JOIN FETCH s.studentCourses sc JOIN FETCH sc.course c WHERE s.name LIKE CONCAT('%',:name,'%')")
  public Set<IFindNameOfStudentWithCourses> findNameAndCoursesOfStudent(@Param("name") String name);
}
