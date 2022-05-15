package com.itechf.student;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    private List<Student> stuList = List.of(new Student(1, "Amit", "12th", null), new Student(2, "Deepak", "9th", null), new Student(3, "Vivek", "10th", null));

    public Student getStudent(Integer id) {
        return stuList.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }
    public List<Student> getAllStudent() {
        return stuList;
    }
}
