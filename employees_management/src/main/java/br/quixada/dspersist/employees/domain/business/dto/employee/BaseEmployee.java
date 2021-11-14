package br.quixada.dspersist.employees.domain.business.dto.employee;

import br.quixada.dspersist.employees.domain.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BaseEmployee {
  private String id;
  @NonNull private String cpf;
  @NonNull private String registration;
  @NonNull private String name;
  @NonNull private String email;
  @NonNull String phone;

  public Employee map() {
    return new Employee(this.id, this.cpf, this.registration, this.name, this.email, this.phone);
  }
}
