package br.com.ufc.quixada.dspersist.schoolmanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class StudentCourse {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @NonNull @Column(name = "student_id", nullable=false)
  private Long studentId;

  @NonNull @Column(name = "course_id",  nullable=false)
  private Long courseId;

  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name="student_id", insertable=false, updatable=false)
  private Student student;

  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name="course_id", insertable=false, updatable=false)
  private Course course;

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof StudentCourse))
      return false;

    StudentCourse sc = (StudentCourse) obj;
    return sc.studentId == this.studentId && sc.courseId == this.courseId;  
  }
}
