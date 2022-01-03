package br.com.ufc.quixada.dspersist.schoolmanagement.repositories;

import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.StudentCourse;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>{
  @Query("SELECT sc FROM StudentCourse sc WHERE sc.studentId = :studentId AND sc.courseId = :courseId")
  public Optional<StudentCourse> findByStudentAndCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);
}
