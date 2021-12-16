package br.com.ufc.quixada.dspersist.schoolmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {}
