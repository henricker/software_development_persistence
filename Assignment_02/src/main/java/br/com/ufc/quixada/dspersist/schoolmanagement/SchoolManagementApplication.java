package br.com.ufc.quixada.dspersist.schoolmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ufc.quixada.dspersist.schoolmanagement.dto.student.searchOptions.IFindNameOfStudentWithCourses;
import br.com.ufc.quixada.dspersist.schoolmanagement.models.StudentCourse;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.CourseRepository;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.StudentCourseRepository;
import br.com.ufc.quixada.dspersist.schoolmanagement.repositories.StudentRepository;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentCourseService;
import br.com.ufc.quixada.dspersist.schoolmanagement.services.StudentService;

@SpringBootApplication
//@Transactional
public class SchoolManagementApplication implements CommandLineRunner {

	@Autowired
	private StudentCourseService service;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentCourseRepository repository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.studentRepository.findNameAndCoursesOfStudent("H").forEach((IFindNameOfStudentWithCourses s) -> {
			System.out.println(s.getName());
			s.getStudentCourses().forEach((StudentCourse sc) -> {
				System.out.println("Course: " + sc.getCourse().getName());
			});
		});

		//System.out.println(this.studentRepository.findStudentsNameAndQuantityOfCourses());
		
	}

}
