package com.itechf.student;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    private List<Student> stuList = List.of(new Student(1, "Amit", "12th"), new Student(2, "Deepak", "9th"), new Student(3, "Vivek", "10th"));

    public Student getStudent(Integer id) {
        return stuList.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }
    public List<Student> getAllStudent() {
        return stuList;
    }
}
