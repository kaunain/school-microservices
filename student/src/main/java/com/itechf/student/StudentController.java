package com.itechf.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentDao dao;
    
    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return dao.getStudent(id);
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
