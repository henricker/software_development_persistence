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
  public Optional<IStudentIdNameAndEmail> findByRegistration(String registration);
  public Optional<Student> findByCpf(String cpf);

  @Query("SELECT e FROM Student e WHERE e.bornDate >= :bornDate")
  public Set<Student> findByDate(@Param("bornDate") LocalDate bornDate);

  @Query("SELECT e.name as name, COUNT(sc.id) as countOfCourses FROM Student e JOIN e.studentCourses sc GROUP BY e.name")
  public Set<IStudentNameAndCountingCourses> findStudentsNameAndQuantityOfCourses();

  @Query("SELECT s FROM Student s JOIN FETCH s.studentCourses sc JOIN FETCH sc.course c WHERE s.name LIKE CONCAT('%',:name,'%')")
  public Set<IFindNameOfStudentWithCourses> findNameAndCoursesOfStudent(@Param("name") String name);
}
