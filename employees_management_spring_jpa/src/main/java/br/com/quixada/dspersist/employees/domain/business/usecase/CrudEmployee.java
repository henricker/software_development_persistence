package br.com.quixada.dspersist.employees.domain.business.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quixada.dspersist.employees.domain.business.dto.CreateEmployeeInputDTO;
import br.com.quixada.dspersist.employees.domain.business.dto.ListEmployeeInputDTO;
import br.com.quixada.dspersist.employees.domain.business.dto.UpdateEmployeeInputDTO;
import br.com.quixada.dspersist.employees.domain.business.errors.employee.BusinessEmployeeException;
import br.com.quixada.dspersist.employees.domain.business.repositories.employee.IEmployeeRepository;
import br.com.quixada.dspersist.employees.domain.entities.Employee;

@Service
public class CrudEmployee {

  @Autowired
  private IEmployeeRepository repository;

  public void create(CreateEmployeeInputDTO data) {
    Boolean cpfExists = this.findByCPF(data.getCpf()) != null;

    if(cpfExists)
      throw BusinessEmployeeException.CPFAlreayExistsError();

    Boolean registrationExists = this.findByRegistration(data.getRegistration()) != null;

    if(registrationExists)
      throw BusinessEmployeeException.registrationAlreadyExistsError();

    Employee employee = data.map();
    this.repository.create(employee);
  }

  public Employee findById(Integer id) {
    return this.repository.findBy("id", id);
  }

  public Employee findByCPF(String cpf) {
    return this.repository.findBy("cpf", cpf);
  }

  public Employee findByRegistration(String registration) {
    return this.repository.findBy("registration", registration);
  }

  public List<Employee> findAll(ListEmployeeInputDTO data) {
    return this.repository.findAll(data.getPage(), data.getLimit());
  }

  public void delete(Integer id) {

    Boolean employeeExists = this.findById(id) != null;
    if(!employeeExists)
      throw BusinessEmployeeException.registrationAlreadyExistsError();
    
    this.repository.deleteBy("id", id);
  }

  public void update(UpdateEmployeeInputDTO data) {

    Boolean employeeExists = this.findById(data.getId()) != null;
    if(!employeeExists)
      throw BusinessEmployeeException.employeeNotFoundError();

    Employee employeeByCPF = this.findByCPF(data.getCpf());
    Boolean cpfExists = employeeByCPF != null;

    if(cpfExists && !employeeByCPF.getId().equals(data.getId()))
      throw BusinessEmployeeException.CPFAlreayExistsError();

    Employee employeeByRegistration = this.findByRegistration(data.getRegistration());
    Boolean registrationExists = employeeByRegistration != null;

    if(registrationExists && !employeeByRegistration.getId().equals(data.getId()))
      throw BusinessEmployeeException.registrationAlreadyExistsError(); 

    this.repository.updateBy("id", data.getId(), data.map());
  }
}
