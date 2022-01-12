package br.com.ufc.quixada.dspersist.schoolmanagement.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

  public Student(Long id, String cpf, String registration, String email, String name, LocalDate bornDate) {
    this.id = id;
    this.cpf = cpf;
    this.registration = registration;
    this.email = email;
    this.name = name;
    this.bornDate = bornDate;
  }

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
  
  @ToString.Exclude
  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<StudentCourse> studentCourses;
}
