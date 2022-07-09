package com.sangomar.student.service;

import com.sangomar.student.model.Student;
import com.sangomar.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImp implements StudentService{
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Student> getStudent(Integer id) {
        return studentRepository.findById(id);
    }

    /**
     * @param student 
     * @return
     */
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @param id 
     */
    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);

    }

    /**
     * @param id
     * @param student
     */
    //@Override
  /*  public void updateStudentById(Integer id, Student student) {
    Optional<Student> s=getStudent(id);

   studentRepository.save(student);

    }*/
}
