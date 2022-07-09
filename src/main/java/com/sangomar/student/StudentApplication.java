package com.sangomar.student;

import com.sangomar.student.model.Student;
import com.sangomar.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@RequiredArgsConstructor

public class StudentApplication  implements CommandLineRunner {
	 private final StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		/*Student s=studentService.addStudent(new Student(1,"pape","778331347"));
		Student s1=studentService.addStudent(new Student(2,"mor","784562102"));
		Student s2=studentService.addStudent(new Student(3,"fatou","701234568"));
		Student s3=studentService.addStudent(new Student(4,"djiby","787331347"));
		Student s4=studentService.addStudent(new Student(5,"bocar","768945236"));
		Student s5=studentService.addStudent(new Student(6,"macky","789652145"));*/

	}
}
