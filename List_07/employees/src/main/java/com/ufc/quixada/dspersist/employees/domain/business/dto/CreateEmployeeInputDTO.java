package com.ufc.quixada.dspersist.employees.domain.business.dto;


import com.ufc.quixada.dspersist.employees.domain.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CreateEmployeeInputDTO {
  @NonNull @Getter @Setter private String cpf;
  @NonNull @Getter @Setter private String registration;
  @NonNull @Getter @Setter private String name;
  @NonNull @Getter @Setter private String email;
  @NonNull @Getter @Setter private String phone;

  public Employee map() {
    return new Employee(cpf, registration, name, email, phone);
  }
}