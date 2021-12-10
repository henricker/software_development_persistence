package com.ufc.quixada.dspersist.employees.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQuery(name = "findByCPF", query = "select e from Employee e where e.cpf = :cpf")
@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Employee {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
  @NonNull private String cpf;
  @NonNull private String registration;
  @NonNull private String name;
  @NonNull private String email;
  @NonNull private String phone;
}