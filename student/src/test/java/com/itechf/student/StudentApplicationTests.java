package com.itechf.student;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApplicationTests {

	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
		System.out.println("Testing Load...");
	}

	@Test
	void isStudentExist() {
		// Student s = new Student(3, "Test", "12th", null);
		Student s = studentRepository.getStudent(3);
		System.out.println(s);
	}
}
