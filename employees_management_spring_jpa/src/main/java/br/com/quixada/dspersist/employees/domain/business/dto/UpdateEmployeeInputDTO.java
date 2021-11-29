package br.com.quixada.dspersist.employees.domain.business.dto;

import br.com.quixada.dspersist.employees.domain.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UpdateEmployeeInputDTO {
  @NonNull @Getter @Setter private Integer id;
  @NonNull @Getter @Setter private String cpf;
  @NonNull @Getter @Setter private String registration;
  @NonNull @Getter @Setter private String name;
  @NonNull @Getter @Setter private String email;
  @NonNull @Getter @Setter private String phone;


  public Employee map() {
    return new Employee(id, cpf, registration, name, email, phone);
  }
}
