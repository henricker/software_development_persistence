package br.com.ufc.quixada.dspersist.schoolmanagement.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  
  @Column(unique = true)
  @NonNull 
  private String cpf;

  @Column(unique = true)
  @NonNull
  private String registration;

  @Column(unique = true)
  @NonNull
  private String email;

  @Column
  @NonNull
  private String name;

  @Column(name = "born_date")
  @NonNull
  private LocalDate bornDate;
}
