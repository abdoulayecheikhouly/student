package com.sangomar.student.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.sangomar.student.model.Student;
import com.sangomar.student.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentServiceImp.class})
@ExtendWith(SpringExtension.class)
class StudentServiceImpTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceImp studentServiceImp;

    /**
     * Method under test: {@link StudentServiceImp#getAllStudent()}
     */
    @Test
    void testGetAllStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> actualAllStudent = studentServiceImp.getAllStudent();
        assertSame(studentList, actualAllStudent);
        assertTrue(actualAllStudent.isEmpty());
        verify(studentRepository).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImp#getStudent(Integer)}
     */
    @Test
    void testGetStudent() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        Optional<Student> ofResult = Optional.of(student);
        when(studentRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Student> actualStudent = studentServiceImp.getStudent(1);
        assertSame(ofResult, actualStudent);
        assertTrue(actualStudent.isPresent());
        verify(studentRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link StudentServiceImp#addStudent(Student)}
     */
    @Test
    void testAddStudent() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        when(studentRepository.save((Student) any())).thenReturn(student);

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertSame(student, studentServiceImp.addStudent(student1));
        verify(studentRepository).save((Student) any());
    }

    /**
     * Method under test: {@link StudentServiceImp#deleteStudent(Integer)}
     */
    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById((Integer) any());
        studentServiceImp.deleteStudent(1);
        verify(studentRepository).deleteById((Integer) any());
    }
}

