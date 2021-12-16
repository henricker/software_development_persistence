package br.com.ufc.quixada.dspersist.schoolmanagement.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Course {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  
  @Column(unique = true)
  @NonNull
  private String code;

  @Column
  @NonNull
  private String name;

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<StudentCourse> studentCourses;
}
