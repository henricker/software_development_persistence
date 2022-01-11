package br.com.ufc.quixada.dspersist.schoolmanagement.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Course;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
  public Optional<Course> findByCode(String code);

  // @Query("SELECT s FROM Course c JOIN c.studentCourses sc JOIN sc.student s  WHERE c.code = :code")
  // //@Query("SELECT s FROM Student s JOIN FETCH s.studentCourses sc JOIN FETCH sc.courses c WHERE c.code = :code")
  // public Set<Student> findStudentsByCodeOfCourse(@Param("code") String code);
}
