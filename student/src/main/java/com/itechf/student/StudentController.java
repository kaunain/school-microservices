package com.itechf.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    @Autowired
    private StudentDao dao;

    @Autowired
    private RestTemplate restTemplate;

    // String teacherUri = "http://localhost:8082/teacher/1";
    String teacherUri = "http://localhost:8082/teacher/1";
    
    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id) {
        Student stu = dao.getStudent(id);
        ResponseEntity<Teacher> teacher = restTemplate.getForEntity(teacherUri, Teacher.class);
        System.out.println("\n\n\n\n------------------" + teacher.getBody());
        stu.setClassTeacher(teacher.getBody());
        return stu;
    }
    @RequestMapping("/all")
    public List<Student> getStudents() {
        return dao.getAllStudent();
    }
    @RequestMapping("/")
    public String home() {
        return "Student Service up and Running";
    }
}
