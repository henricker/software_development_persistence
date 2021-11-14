package br.quixada.dspersist.employees.data.postgres.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.quixada.dspersist.employees.domain.business.module.errors.employee.EmployeeErrors;
import br.quixada.dspersist.employees.domain.business.repositories.IEmployeeRepository;
import br.quixada.dspersist.employees.domain.entities.Employee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeRepositoryJDBCPostgres implements IEmployeeRepository {

  @NonNull Connection connection;
  private final List<String> acceptUniqueKeys = new ArrayList<>(Arrays.asList("id", "cpf", "registration")); // to evict SQL injection and allows dynamic search

  @Override
  public void create(Employee employee) {
    String sql = "INSERT INTO employees(id, cpf, registration, name, email, phone) VALUES(?, ?, ?, ?, ?, ?);";
    try(PreparedStatement ps = this.connection.prepareStatement(sql)) {
      ps.setString(1, employee.getId());
      ps.setString(2, employee.getCpf());
      ps.setString(3, employee.getRegistration());
      ps.setString(4, employee.getName());
      ps.setString(5, employee.getEmail());
      ps.setString(6, employee.getPhone());

      ps.execute();
    } catch(SQLException err) {
      throw EmployeeErrors.employeeCreationError();
    }
  }

  @Override
  public Employee findBy(String uniqueKey, Object value) {
    try {
      if(!this.acceptUniqueKeys.contains(uniqueKey))
        throw new SQLException();

      String sql = "SELECT * FROM employees WHERE " + uniqueKey + " = ?";
    
      Employee employee = null;
      PreparedStatement ps = this.connection.prepareStatement(sql);
      
  
      if(value instanceof String)
         ps.setString(1, String.valueOf(value));
      else if(value instanceof Integer)
        ps.setInt(1, Integer.valueOf(String.valueOf(value)));
      else if(value instanceof Long)
        ps.setLong(5, Long.valueOf(String.valueOf(value)));
      else  
        throw new SQLException();

      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        employee = this.map(rs);
      }
      return employee;

    } catch(SQLException err) {
      throw EmployeeErrors.employeeFindError();
    }
  }

  @Override
  public void updateBy(String uniqueKey, Object valueUniqueKey, Employee employee) {
    try {
      if(!this.acceptUniqueKeys.contains(uniqueKey))
        throw new SQLException();
      
      String sql = "UPDATE employees SET name = ?, email = ?, phone = ?, registration = ? WHERE " + uniqueKey + " = ?";
      PreparedStatement ps = this.connection.prepareStatement(sql);

      ps.setString(1, employee.getName());
      ps.setString(2, employee.getEmail());
      ps.setString(3, employee.getPhone());
      ps.setString(4, employee.getRegistration());

      if(valueUniqueKey instanceof String)
        ps.setString(5, String.valueOf(valueUniqueKey));
      else if(valueUniqueKey instanceof Integer)
        ps.setInt(5, Integer.valueOf(String.valueOf(valueUniqueKey)));
      else if(valueUniqueKey instanceof Long)
        ps.setLong(5, Long.valueOf(String.valueOf(valueUniqueKey)));
      else  
        throw new SQLException();

      ps.execute();
  
    } catch(SQLException err) {
      System.out.println(err.getMessage());
      throw EmployeeErrors.employeeUpdateError();
    }
  }

  @Override
  public List<Employee> findAll(Integer page, Integer limit) {
    String sql = "SELECT * FROM employees OFFSET ? LIMIT ?";
    List<Employee> employees = new ArrayList<>();
    try(PreparedStatement ps = this.connection.prepareStatement(sql)) {
      ps.setInt(1, (page - 1) * limit);
      ps.setInt(2, limit);

      ResultSet rs = ps.executeQuery();
      while(rs.next())
        employees.add(this.map(rs));
    
      return employees;
    } catch(SQLException err) {
      throw EmployeeErrors.employeeListError();
    }
  }

  @Override
  public void deleteBy(String uniqueKey, Object value) {
    String sql = "DELETE FROM employees WHERE ? = ?";
    try(PreparedStatement ps = this.connection.prepareStatement(sql)){
      ps.setString(1, uniqueKey);

      if (value instanceof String)
        ps.setString(2, String.valueOf(value));
      else if(value instanceof Integer)
        ps.setInt(2, Integer.valueOf(String.valueOf(value)));
      else if(value instanceof Long)
        ps.setLong(5, Long.valueOf(String.valueOf(value)));
      else  
        throw new SQLException();

      ps.execute();
    } catch(SQLException err) {
      throw EmployeeErrors.employeeDeleteError();
    }
  }

  private Employee map(ResultSet rs) throws SQLException {
    Employee employee = new Employee(
      rs.getString("id"), 
      rs.getString("cpf"), 
      rs.getString("registration"), 
      rs.getString("name"), 
      rs.getString("email"), 
      rs.getString("phone")
    );

    return employee;
  }
  
}
