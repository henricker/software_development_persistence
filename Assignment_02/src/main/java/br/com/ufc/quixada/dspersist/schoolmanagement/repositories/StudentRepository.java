package br.com.ufc.quixada.dspersist.schoolmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.dspersist.schoolmanagement.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
