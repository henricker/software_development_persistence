package br.com.ufc.quixada.dspersist.schoolmanagement.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

  @ManyToMany
  @JoinTable(
    name = "students_courses",
    joinColumns = @JoinColumn( name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  private List<Course> courses;
}
