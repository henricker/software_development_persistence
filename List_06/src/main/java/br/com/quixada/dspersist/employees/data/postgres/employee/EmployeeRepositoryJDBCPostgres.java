package br.com.quixada.dspersist.employees.data.postgres.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.quixada.dspersist.employees.domain.business.repositories.employee.IEmployeeRepository;
import br.com.quixada.dspersist.employees.domain.entities.Employee;

@Repository
public class EmployeeRepositoryJDBCPostgres implements IEmployeeRepository {

  private final List<String> uniqueKeys = new ArrayList<>(Arrays.asList("id", "registration", "cpf"));

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void create(Employee employee) {
    String sql = "INSERT INTO employees(id, cpf, registration, name, email, phone) VALUES(:id, :cpf, :registration, :name, :email, :phone);";
    SqlParameterSource paramSource = new MapSqlParameterSource()
          .addValue("id", employee.getId())
          .addValue("cpf", employee.getCpf())
          .addValue("registration", employee.getRegistration())
          .addValue("name", employee.getName())
          .addValue("email", employee.getEmail())
          .addValue("phone", employee.getPhone());

    this.jdbcTemplate.update(sql, paramSource);
  }

  //SELECT * FROM employees WHERE ;DELETE FROM employees; = 1
  @Override
  public Employee findBy(String uniqueKey, Object value) {
    if(!this.uniqueKeys.contains(uniqueKey))
      throw new RuntimeException("Invalid unique key!");
    
    try {
      String sql = "SELECT * from employees WHERE " + uniqueKey + " = :value";
      SqlParameterSource paramSource = new MapSqlParameterSource()
            .addValue("value", value);
  
      return this.jdbcTemplate.queryForObject(sql, paramSource, (rs, rowNum) -> map(rs));
    } catch(DataAccessException exception) {
      return null;
    } catch(NestedRuntimeException exception) {
      throw exception;
    }
  }

  @Override
  public void updateBy(String uniqueKey, Object value, Employee employee) {
    if(!this.uniqueKeys.contains(uniqueKey))
      throw new RuntimeException("Invalid unique key!");

    String sql = "UPDATE employees SET name = :name, email = :email, phone = :phone, registration = :registration WHERE " + uniqueKey + " = :value";
    
    SqlParameterSource paramSource = new MapSqlParameterSource()
          .addValue("name", employee.getName())
          .addValue("email", employee.getEmail())
          .addValue("phone", employee.getPhone())
          .addValue("registration", employee.getRegistration())
          .addValue("value", value);

    this.jdbcTemplate.update(sql, paramSource);
  }

  @Override
  public List<Employee> findAll(Integer page, Integer limit) {
    String sql = "SELECT * FROM employees OFFSET :page LIMIT :limit";
    SqlParameterSource paramSource = new MapSqlParameterSource()
      .addValue("page", (page - 1) * limit)
      .addValue("limit", limit);
    
    return this.jdbcTemplate.query(sql, paramSource, (rs, rowNum) -> map(rs));
  }

  @Override
  public void deleteBy(String uniqueKey, Object value) {
    if(!this.uniqueKeys.contains(uniqueKey))
      throw new RuntimeException("Invalid unique key!");

    String sql = "DELETE FROM employees WHERE " + uniqueKey + " = :value";
    SqlParameterSource paramSource = new MapSqlParameterSource()
        .addValue("value", value);
    
    this.jdbcTemplate.update(sql, paramSource);
  }

  private Employee map(ResultSet rs) throws SQLException {
    Employee employee = new Employee(
      rs.getInt("id"), 
      rs.getString("cpf"), 
      rs.getString("registration"), 
      rs.getString("name"), 
      rs.getString("email"), 
      rs.getString("phone")
    );

    return employee;
  }
}
