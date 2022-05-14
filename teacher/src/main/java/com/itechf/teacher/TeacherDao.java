package com.itechf.teacher;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao {

    private List<Teacher> stuList = List.of(new Teacher(1, "Saleem Sir", "12th"), new Teacher(2, "Ayyub Sir", "9th"), new Teacher(3, "Tufail Sir", "10th"));

    public Teacher getTeacher(Integer id) {
        return stuList.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }
    public List<Teacher> getAllTeacher() {
        return stuList;
    }
}
