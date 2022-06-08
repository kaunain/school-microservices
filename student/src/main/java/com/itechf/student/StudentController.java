package com.itechf.student;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository dao;

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
    @RequestMapping("/get/{id}")
    @Cacheable("student")
    public Student getOneStudent(@PathVariable Integer id) {
        Student stu = new Student(id, "Vivek", "12th", null, new Date());
        return stu;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<List<Student>>(dao.getAllStudent(), HttpStatus.OK);
    }
    @RequestMapping("/")
    public String home() {
        return "Student Service up and Running";
    }

}
