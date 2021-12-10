package br.com.quixada.dspersist.employees.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
  @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
  @NonNull @Getter @Setter private String cpf;
  @NonNull @Getter @Setter private String registration;
  @NonNull @Getter @Setter private String name;
  @NonNull @Getter @Setter private String email;
  @NonNull @Getter @Setter private String phone;
}
