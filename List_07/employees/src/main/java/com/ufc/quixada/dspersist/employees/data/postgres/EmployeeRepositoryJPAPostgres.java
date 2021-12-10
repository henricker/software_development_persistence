package com.ufc.quixada.dspersist.employees.data.postgres;

import java.util.Optional;

import com.ufc.quixada.dspersist.employees.domain.entities.Employee;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryJPAPostgres extends JpaRepository<Employee, Integer> {

  @Query(name = "findByCPF")
  public Optional<Employee> findByCPF(String cpf); //named query
  public Optional<Employee> findByRegistration(String registration); //query based on no Spring Data JPA method name
  
  @Query("select e from Employee e") //@Query of Spring Data JPA
  public Page<Employee> findAllWithPagination(Pageable pageable);
}