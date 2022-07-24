package com.sangomar.student.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangomar.student.model.Student;
import com.sangomar.student.service.StudentService;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentService studentService;

    /**
     * Method under test: {@link StudentController#addProduct(Student)}
     */
    @Test
    void testAddProduct() throws Exception {
        when(studentService.getAllStudent()).thenReturn(new ArrayList<>());

        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(student);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#allStudent()}
     */
    @Test
    void testAllStudent() throws Exception {
        when(studentService.getAllStudent()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/student");
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#deleteProduct(Integer)}
     */
    @Test
    void testDeleteProduct() throws Exception {
        doNothing().when(studentService).deleteStudent((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/student/{id}", 1);
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link StudentController#getProduct(Integer)}
     */
    @Test
    void testGetProduct() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        Optional<Student> ofResult = Optional.of(student);
        when(studentService.getStudent((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/student/{id}", 1);
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"mobileNo\":\"Mobile No\"}"));
    }

    /**
     * Method under test: {@link StudentController#updateStudent(Integer, Student)}
     */
    @Test
    void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        Optional<Student> ofResult = Optional.of(student1);
        when(studentService.addStudent((Student) any())).thenReturn(student);
        when(studentService.getStudent((Integer) any())).thenReturn(ofResult);

        Student student2 = new Student();
        student2.setId(1);
        student2.setMobileNo("Mobile No");
        student2.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(student2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/student/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link StudentController#updateStudent(Integer, Student)}
     */
    @Test
    void testUpdateStudent2() throws Exception {
        when(studentService.addStudent((Student) any())).thenThrow(new NoSuchElementException("?"));
        when(studentService.getStudent((Integer) any())).thenThrow(new NoSuchElementException("?"));

        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(student);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/student/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

