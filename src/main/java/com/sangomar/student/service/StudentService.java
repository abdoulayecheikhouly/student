package com.sangomar.student.service;

import com.sangomar.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();
    Optional<Student> getStudent(Integer id);
    Student addStudent(Student student);
    void deleteStudent(Integer id);

    //void updateStudentById(Integer id, Student student);
}
