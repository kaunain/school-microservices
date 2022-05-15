package com.itechf.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherDao dao;
    
    @RequestMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable Integer id) {
        return dao.getTeacher(id);
    }
    @RequestMapping("/all")
    public List<Teacher> getTeachers() {
        return dao.getAllTeacher();
    }
    @RequestMapping("/")
    public String home() {
        return "Teacher Service up and Running";
    }
}
