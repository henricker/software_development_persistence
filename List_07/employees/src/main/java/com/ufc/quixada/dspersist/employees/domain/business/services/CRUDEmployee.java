package com.ufc.quixada.dspersist.employees.domain.business.services;

import java.util.List;
import java.util.Optional;

import com.ufc.quixada.dspersist.employees.data.postgres.EmployeeRepositoryJPAPostgres;
import com.ufc.quixada.dspersist.employees.domain.business.dto.CreateEmployeeInputDTO;
import com.ufc.quixada.dspersist.employees.domain.business.dto.ListEmployeeInputDTO;
import com.ufc.quixada.dspersist.employees.domain.business.dto.UpdateEmployeeInputDTO;
import com.ufc.quixada.dspersist.employees.domain.business.errors.employee.BusinessEmployeeException;
import com.ufc.quixada.dspersist.employees.domain.entities.Employee;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUDEmployee {

  @Autowired
  private EmployeeRepositoryJPAPostgres repository;

  public void create(CreateEmployeeInputDTO data) {
    Optional<Employee> cpfExists = this.findByCPF(data.getCpf());

    if(cpfExists.isPresent())
      throw BusinessEmployeeException.cpfAlreayExistsError();

    Optional<Employee> registrationExists = this.findByRegistration(data.getRegistration());

    if(registrationExists.isPresent())
      throw BusinessEmployeeException.registrationAlreadyExistsError();

    Employee employee = data.map();

    this.repository.save(employee);
  }

  public Optional<Employee> findById(Integer id) {
    return this.repository.findById(id);
  }

  public Optional<Employee> findByCPF(String cpf) {
    return this.repository.findByCPF(cpf);
  }

  public Optional<Employee> findByRegistration(String registration) {
    return this.repository.findByRegistration(registration);
  }

  public List<Employee> findAll(ListEmployeeInputDTO data) {
    PageRequest pageRequest = PageRequest.of(data.getPage(), data.getLimit(), Sort.Direction.DESC, "id");
    return this.repository.findAllWithPagination(pageRequest).getContent();
  }

  public void delete(Integer id) {

    Optional<Employee> employeeExists = this.findById(id);
    if(!employeeExists.isPresent())
      throw BusinessEmployeeException.registrationAlreadyExistsError();
    
    this.repository.deleteById(id);
  }

  public void update(UpdateEmployeeInputDTO data) {

    Optional<Employee> employeeExists = this.findById(data.getId());

    if(!employeeExists.isPresent())
      throw BusinessEmployeeException.employeeNotFoundError();

    Optional<Employee> employeeByCPF = this.findByCPF(data.getCpf());

    if(employeeByCPF.isPresent() && !employeeByCPF.get().getId().equals(data.getId()))
      throw BusinessEmployeeException.cpfAlreayExistsError();

    Optional<Employee> employeeByRegistration = this.findByRegistration(data.getRegistration());

    if(employeeByRegistration.isPresent() && !employeeByRegistration.get().getId().equals(data.getId()))
      throw BusinessEmployeeException.registrationAlreadyExistsError(); 

    this.repository.save(data.map());
  }
}